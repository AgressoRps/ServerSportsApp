package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Rank;
import org.communis.serversportsapp.entity.RankUser;
import org.communis.serversportsapp.entity.UserApp;

import java.io.Serializable;

@Data
public class RankUserWrapper implements ObjectWrapper<RankUser>, Serializable {

    private Long id;
    private UserApp userApp;
    private Rank rank;

    public RankUserWrapper (RankUser rankUser){
        toWrapper(rankUser);
    }

    /**
     * Добавление данных объекта RankUser в объект RankUserWrapper
     * @param item - экземпляр объекта RankUser
     */
    @Override
    public void toWrapper(RankUser item) {
        if (item != null){
            id = item.getId();
            userApp = item.getUser();
            rank = item.getRank();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта RankUser, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(RankUser item) {
        if (item != null){
            item.setId(id);
            item.setUser(userApp);
            item.setRank(rank);
        }
    }
}

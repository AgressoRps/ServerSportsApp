package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Rank;

import java.io.Serializable;

@Data
public class RankWrapper implements ObjectWrapper<Rank>, Serializable {

    private Short id;
    private String name;

    public RankWrapper(){}

    public RankWrapper(Rank rank){
        toWrapper(rank);
    }

    /**
     * Добавление данных объекта Rank в объект RankWrapper
     * @param item - экземпляр объекта Rank
     */
    @Override
    public void toWrapper(Rank item) {
        if (item != null){
            id = item.getId();
            name = item.getName();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта Rank, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(Rank item) {
        if (item != null){
            item.setId(id);
            item.setName(name);
        }
    }
}

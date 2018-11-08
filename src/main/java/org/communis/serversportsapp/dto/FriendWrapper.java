package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Friend;
import org.communis.serversportsapp.entity.UserApp;

import java.io.Serializable;

@Data
public class FriendWrapper implements ObjectWrapper<Friend>, Serializable {

    private Long id;
    private UserApp userApp;
    private UserApp friend;

    public FriendWrapper (Friend friend){
        toWrapper(friend);
    }

    /**
     * Добавление данных объекта Friend в объект FriendWrapper
     * @param item - экземпляр объекта Friend
     */
    @Override
    public void toWrapper(Friend item) {
        if (item != null){
            id = item.getId();
            userApp = item.getUser();
            friend = item.getFriend();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта Friend, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(Friend item) {
        if (item != null){
            item.setId(id);
            item.setUser(userApp);
            item.setFriend(friend);
        }
    }
}

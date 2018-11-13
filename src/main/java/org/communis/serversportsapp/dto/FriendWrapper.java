package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Friend;
import org.communis.serversportsapp.entity.UserApp;

import java.io.Serializable;

@Data
public class FriendWrapper implements ObjectWrapper<Friend>, Serializable {

    private Long id;
    private Long userID;
    private UserAppWrapper friendWrapper = new UserAppWrapper();

    public FriendWrapper(){}

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
            userID = item.getUserID();
            friendWrapper = new UserAppWrapper(item.getFriend());
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
            item.setUserID(userID);
            UserApp friendAttr = new UserApp();
            friendWrapper.fromWrapper(friendAttr);
            item.setFriend(friendAttr);
        }
    }
}

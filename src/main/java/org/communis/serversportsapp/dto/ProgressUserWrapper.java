package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Progress;
import org.communis.serversportsapp.entity.ProgressUser;
import org.communis.serversportsapp.entity.UserApp;

import java.io.Serializable;

@Data
public class ProgressUserWrapper implements ObjectWrapper<ProgressUser>, Serializable {

    private Long id;
    private UserApp user;
    private Progress progress;

    public ProgressUserWrapper(ProgressUser progressUser){
        toWrapper(progressUser);
    }

    /**
     * Добавление данных объекта ProgressUser в объект ProgressUserWrapper
     * @param item - экземпляр объекта ProgressUser
     */
    @Override
    public void toWrapper(ProgressUser item) {
        if (item != null){
            id = item.getId();
            user = item.getUser();
            progress = item.getProgress();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта ProgressUser, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(ProgressUser item) {
        if (item != null){
            item.setId(id);
            item.setUser(user);
            item.setProgress(progress);
        }
    }
}

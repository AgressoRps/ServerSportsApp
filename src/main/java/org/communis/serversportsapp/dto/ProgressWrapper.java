package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Progress;

import java.io.Serializable;

@Data
public class ProgressWrapper implements ObjectWrapper<Progress>, Serializable {

    private Short id;
    private String name;

    public ProgressWrapper(Progress progress){
        toWrapper(progress);
    }

    /**
     * Добавление данных объекта Progress в объект ProgressWrapper
     * @param item - экземпляр объекта Progress
     */
    @Override
    public void toWrapper(Progress item) {
        if (item != null){
            id = item.getId();
            name = item.getName();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта Progress, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(Progress item) {
        if (item != null){
            item.setId(id);
            item.setName(name);
        }
    }
}

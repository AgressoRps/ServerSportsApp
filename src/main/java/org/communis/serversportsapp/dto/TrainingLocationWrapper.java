package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.TrainingLocation;

import java.io.Serializable;

@Data
public class TrainingLocationWrapper implements ObjectWrapper<TrainingLocation>, Serializable {

    private Short id;
    private String name;

    public TrainingLocationWrapper(){}

    public TrainingLocationWrapper(TrainingLocation trainingLocation){
        toWrapper(trainingLocation);
    }

    /**
     * Добавление данных объекта TrainingLocation в объект TrainingLocationWrapper
     * @param item - экземпляр объекта TrainingLocation
     */
    @Override
    public void toWrapper(TrainingLocation item) {
        if (item != null){
            id = item.getId();
            name = item.getName();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта TrainingLocation, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(TrainingLocation item) {
        if (item != null){
            item.setId(id);
            item.setName(name);
        }
    }
}

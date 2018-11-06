package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Day;
import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.entity.TrainingProgram;
import org.communis.serversportsapp.enums.TrainingDayState;

import java.io.Serializable;

@Data
public class TrainingDayWrapper implements ObjectWrapper<TrainingDay>, Serializable {

    private Long id;
    private TrainingProgram trainingProgram;
    private Day day;
    private TrainingDayState trainingDayState;

    public TrainingDayWrapper(TrainingDay trainingDay){
        toWrapper(trainingDay);
    }

    /**
     * Добавление данных объекта TrainingDay в объект TrainingDayWrapper
     * @param item - экземпляр объекта TrainingDay
     */
    @Override
    public void toWrapper(TrainingDay item) {
        if (item != null){
            id = item.getId();
            trainingProgram = item.getTrainingProgram();
            day = item.getDay();
            trainingDayState = item.getTrainingDayState();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта TrainingDay, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(TrainingDay item) {
        if (item != null){
            item.setId(id);
            item.setTrainingProgram(trainingProgram);
            item.setDay(day);
            item.setTrainingDayState(trainingDayState);
        }
    }
}

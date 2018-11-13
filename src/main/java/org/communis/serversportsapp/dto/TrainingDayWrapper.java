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
    private Long trainingProgramID;
    private DayWrapper dayWrapper = new DayWrapper();
    private TrainingDayState trainingDayState;

    public TrainingDayWrapper(){}

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
            trainingProgramID = item.getTrainingProgramID();
            dayWrapper = new DayWrapper(item.getDay());
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
            item.setTrainingProgramID(trainingProgramID);
            Day dayAttr = new Day();
            dayWrapper.fromWrapper(dayAttr);
            item.setDay(dayAttr);
            item.setTrainingDayState(trainingDayState);
        }
    }
}

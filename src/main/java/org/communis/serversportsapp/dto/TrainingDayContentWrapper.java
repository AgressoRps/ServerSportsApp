package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Exercise;
import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.entity.TrainingDayContent;

import java.io.Serializable;

@Data
public class TrainingDayContentWrapper implements ObjectWrapper<TrainingDayContent>, Serializable {

    private Long id;
    private Long trainingDayID;
    private ExerciseWrapper exerciseWrapper = new ExerciseWrapper();
    private Short numberRepetitions;

    public TrainingDayContentWrapper(TrainingDayContent trainingDayContent){
        toWrapper(trainingDayContent);
    }

    /**
     * Добавление данных объекта TrainingDayContent в объект TrainingDayContentWrapper
     * @param item - экземпляр объекта TrainingDayContent
     */
    @Override
    public void toWrapper(TrainingDayContent item) {
        if (item != null){
            id = item.getId();
            trainingDayID = item.getTrainingDayID();
            exerciseWrapper = new ExerciseWrapper(item.getExercise());
            numberRepetitions = item.getNumberRepetitions();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта TrainingDayContent, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(TrainingDayContent item) {
        if (item != null){
            item.setId(id);
            item.setTrainingDayID(trainingDayID);
            Exercise exerciseAttr = new Exercise();
            exerciseWrapper.fromWrapper(exerciseAttr);
            item.setExercise(exerciseAttr);
            item.setNumberRepetitions(numberRepetitions);
        }
    }
}

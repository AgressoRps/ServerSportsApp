package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Exercise;
import org.communis.serversportsapp.entity.TrainingDay;
import org.communis.serversportsapp.entity.TrainingDayContent;

import java.io.Serializable;

@Data
public class TrainingDayContentWrapper implements ObjectWrapper<TrainingDayContent>, Serializable {

    private Long id;
    private TrainingDay trainingDay;
    private Exercise exercise;
    private Short numberRepetitions;

    public TrainingDayContentWrapper(TrainingDayContent trainingDayContent){
        toWrapper(trainingDayContent);
    }

    @Override
    public void toWrapper(TrainingDayContent item) {
        if (item != null){
            id = item.getId();
            trainingDay = item.getTrainingDay();
            exercise = item.getExercise();
            numberRepetitions = item.getNumberRepetitions();
        }
    }

    @Override
    public void fromWrapper(TrainingDayContent item) {
        if (item != null){
            item.setId(id);
            item.setTrainingDay(trainingDay);
            item.setExercise(exercise);
            item.setNumberRepetitions(numberRepetitions);
        }
    }
}

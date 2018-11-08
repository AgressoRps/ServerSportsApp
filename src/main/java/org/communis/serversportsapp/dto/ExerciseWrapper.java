package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Exercise;
import org.communis.serversportsapp.entity.TrainingLocation;
import org.communis.serversportsapp.enums.ExerciseTimeState;

import java.io.Serializable;

@Data
public class ExerciseWrapper implements ObjectWrapper<Exercise>, Serializable {

    private Short id;
    private TrainingLocation trainingLocation;
    private String name;
    private String photoName;
    private ExerciseTimeState exerciseTimeState;

    public ExerciseWrapper(Exercise exercise){
        toWrapper(exercise);
    }

    @Override
    public void toWrapper(Exercise item) {
        if (item != null){
            id = item.getId();
            trainingLocation = item.getTrainingLocation();
            name = item.getName();
            photoName = item.getPhotoName();
            exerciseTimeState = item.getExerciseTimeState();
        }
    }

    @Override
    public void fromWrapper(Exercise item) {
        if (item != null){
            item.setId(id);
            item.setTrainingLocation(trainingLocation);
            item.setName(name);
            item.setPhotoName(photoName);
            item.setExerciseTimeState(exerciseTimeState);
        }
    }
}

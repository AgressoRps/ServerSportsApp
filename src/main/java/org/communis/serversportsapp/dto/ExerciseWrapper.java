package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.Exercise;
import org.communis.serversportsapp.entity.TrainingLocation;
import org.communis.serversportsapp.enums.ExerciseTimeState;

import java.io.Serializable;

@Data
public class ExerciseWrapper implements ObjectWrapper<Exercise>, Serializable {

    private Short id;
    private Short trainingLocationID;
    private String name;
    private String photoName;
    private ExerciseTimeState exerciseTimeState;

    public ExerciseWrapper(){}

    public ExerciseWrapper(Exercise exercise){
        toWrapper(exercise);
    }

    /**
     * Добавление данных объекта Exercise в объект Exercise Wrapper
     * @param item - экземпляр объекта Exercise
     */
    @Override
    public void toWrapper(Exercise item) {
        if (item != null){
            id = item.getId();
            trainingLocationID = item.getTrainingLocationID();
            name = item.getName();
            photoName = item.getPhotoName();
            exerciseTimeState = item.getExerciseTimeState();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта Exercise, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(Exercise item) {
        if (item != null){
            item.setId(id);
            item.setTrainingLocationID(trainingLocationID);
            item.setName(name);
            item.setPhotoName(photoName);
            item.setExerciseTimeState(exerciseTimeState);
        }
    }
}

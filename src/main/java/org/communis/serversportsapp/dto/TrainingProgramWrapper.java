package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.LevelDifficulty;
import org.communis.serversportsapp.entity.TrainingLocation;
import org.communis.serversportsapp.entity.TrainingProgram;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.enums.TrainingProgramState;

import java.io.Serializable;

@Data
public class TrainingProgramWrapper implements ObjectWrapper<TrainingProgram>, Serializable{

    private Long id;
    private UserApp user;
    private TrainingLocation trainingLocation;
    private LevelDifficulty levelDifficulty;
    private String trainingProgramName;
    private String photoName;
    private Short timeBetweenExecution;
    private TrainingProgramState trainingProgramState;


    public TrainingProgramWrapper(){

    }

    public TrainingProgramWrapper(TrainingProgram trainingProgram){
        toWrapper(trainingProgram);
    }

    /**
     * Добавление данных объекта TrainingProgram в объект TrainingProgramWrapper
     * @param item - экземпляр объекта TrainingProgram
     */
    @Override
    public void toWrapper(TrainingProgram item) {
        if (item != null){
            id = item.getId();
            user = item.getUser();
            trainingLocation = item.getTrainingLocation();
            levelDifficulty = item.getLevelDifficulty();
            trainingProgramName = item.getTrainingProgramName();
            photoName = item.getPhotoName();
            timeBetweenExecution = item.getTimeBetweenExecution();
            trainingProgramState = item.getTrainingProgramState();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта TrainingProgram, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(TrainingProgram item) {
        if (item != null){
            item.setId(id);
            item.setUser(user);
            item.setTrainingLocation(trainingLocation);
            item.setLevelDifficulty(levelDifficulty);
            item.setTrainingProgramName(trainingProgramName);
            item.setPhotoName(photoName);
            item.setTimeBetweenExecution(timeBetweenExecution);
            item.setTrainingProgramState(trainingProgramState);
        }
    }
}

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
    private Long userID;
    private Short trainingLocationID;
    private LevelDifficultyWrapper levelDifficultyWrapper = new LevelDifficultyWrapper();
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
            userID = item.getUserID();
            trainingLocationID = item.getTrainingLocationID();
            levelDifficultyWrapper = new LevelDifficultyWrapper(item.getLevelDifficulty());
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
            item.setUserID(userID);
            item.setTrainingLocationID(trainingLocationID);
            LevelDifficulty levelDifficultyAttr = new LevelDifficulty();
            levelDifficultyWrapper.fromWrapper(levelDifficultyAttr);
            item.setLevelDifficulty(levelDifficultyAttr);
            item.setTrainingProgramName(trainingProgramName);
            item.setPhotoName(photoName);
            item.setTimeBetweenExecution(timeBetweenExecution);
            item.setTrainingProgramState(trainingProgramState);
        }
    }
}

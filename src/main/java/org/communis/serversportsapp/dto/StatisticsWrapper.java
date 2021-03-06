package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.*;
import org.communis.serversportsapp.enums.DifficultyState;
import org.communis.serversportsapp.enums.HealthState;
import org.communis.serversportsapp.enums.MoodState;

import java.io.Serializable;
import java.util.Date;

@Data
public class StatisticsWrapper implements ObjectWrapper<Statistics>, Serializable {

    private Long id;
    private Long userID;
    private Short trainingLocationID;
    private Long trainingProgramID;
    private Long trainingDayID;
    private Integer timeSpent;
    private Short numberApproaches;
    private Integer metersTraveled;
    private Short numberRepetitions;
    private Short completedExercises;
    private Short percentageEfficiency;
    private HealthState healthStateBefore;
    private HealthState healthStateAfter;
    private MoodState moodStateBefore;
    private MoodState moodStateAfter;
    private DifficultyState difficultyState;
    private Date dateTime;

    public StatisticsWrapper(){}

    public StatisticsWrapper(Statistics statistics){
        toWrapper(statistics);
    }

    @Override
    public void toWrapper(Statistics item) {
        if (item != null){
            id = item.getId();
            userID = item.getUserID();
            trainingLocationID = item.getTrainingLocationID();
            trainingProgramID = item.getTrainingProgramID();
            trainingDayID = item.getTrainingDayID();
            timeSpent = item.getTimeSpent();
            numberApproaches = item.getNumberApproaches();
            metersTraveled = item.getMetersTraveled();
            numberRepetitions = item.getNumberRepetitions();
            completedExercises = item.getCompletedExercises();
            percentageEfficiency = item.getPercentageEfficiency();
            healthStateBefore = item.getHealthStateBefore();
            healthStateAfter = item.getHealthStateAfter();
            moodStateBefore = item.getMoodStateBefore();
            moodStateAfter = item.getMoodStateAfter();
            difficultyState = item.getDifficultyState();
            dateTime = item.getDateTime();
        }
    }

    @Override
    public void fromWrapper(Statistics item) {
        if (item != null){
            item.setId(id);
            item.setUserID(userID);
            item.setTrainingLocationID(trainingLocationID);
            item.setTrainingProgramID(trainingProgramID);
            item.setTrainingDayID(trainingDayID);
            item.setTimeSpent(timeSpent);
            item.setNumberApproaches(numberApproaches);
            item.setMetersTraveled(metersTraveled);
            item.setNumberRepetitions(numberRepetitions);
            item.setCompletedExercises(completedExercises);
            item.setPercentageEfficiency(percentageEfficiency);
            item.setHealthStateBefore(healthStateBefore);
            item.setHealthStateAfter(healthStateAfter);
            item.setMoodStateBefore(moodStateBefore);
            item.setMoodStateAfter(moodStateAfter);
            item.setDifficultyState(difficultyState);
            item.setDateTime(dateTime);
        }
    }
}

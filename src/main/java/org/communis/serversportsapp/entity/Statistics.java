package org.communis.serversportsapp.entity;

import lombok.Data;
import org.communis.serversportsapp.enums.DifficultyState;
import org.communis.serversportsapp.enums.HealthState;
import org.communis.serversportsapp.enums.MoodState;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_user_app")
    private Long userID;

    @Column(name = "id_training_location")
    private Short trainingLocationID;

    @Column(name = "id_training_program")
    private Long trainingProgramID;

    @Column(name = "id_training_day")
    private Long trainingDayID;

    @Column(name = "time_spent")
    private Integer timeSpent;

    @Column(name = "number_approaches")
    private Short numberApproaches;

    @Column(name = "meters_traveled")
    private Integer metersTraveled;

    @Column(name = "number_repetitions")
    private Short numberRepetitions;

    @Column(name = "completed_exercises")
    private Short completedExercises;

    @Column(name = "percentage_efficiency")
    private Short percentageEfficiency;

    @Enumerated(EnumType.STRING)
    @Column(name = "feeling_before")
    private HealthState healthStateBefore;

    @Enumerated(EnumType.STRING)
    @Column(name = "feeling_after")
    private HealthState healthStateAfter;

    @Enumerated(EnumType.STRING)
    @Column(name = "mood_before")
    private MoodState moodStateBefore;

    @Enumerated(EnumType.STRING)
    @Column(name = "mood_after")
    private MoodState moodStateAfter;

    @Enumerated(EnumType.STRING)
    @Column(name = "exercise_difficulty")
    private DifficultyState difficultyState;

    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

}

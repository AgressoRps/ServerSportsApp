package org.communis.serversportsapp.entity;

import lombok.Data;
import org.communis.serversportsapp.enums.TrainingProgramState;

import javax.persistence.*;

@Data
@Entity
@Table(name = "training_program")
public class TrainingProgram {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_user_app")
    private Long userID;

    @Column(name = "id_training_location")
    private Short trainingLocationID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_level_difficulty")
    private LevelDifficulty levelDifficulty;

    @Column(name = "training_program_name")
    private String trainingProgramName;

    @Column(name = "photo_name")
    private String photoName;

    @Column(name = "time_between_execution")
    private Short timeBetweenExecution;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_complete")
    private TrainingProgramState trainingProgramState;

}

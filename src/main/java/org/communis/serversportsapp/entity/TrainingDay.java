package org.communis.serversportsapp.entity;

import lombok.Data;
import org.communis.serversportsapp.enums.TrainingDayState;

import javax.persistence.*;

@Data
@Entity
@Table(name = "training_day")
public class TrainingDay {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_training_program")
    private Long trainingProgramID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_day")
    private Day day;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_complete")
    private TrainingDayState trainingDayState;

}

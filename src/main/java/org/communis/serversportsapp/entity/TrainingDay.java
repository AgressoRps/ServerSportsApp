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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_training_program")
    private TrainingProgram trainingProgram;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_day")
    private Day day;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_complete")
    private TrainingDayState trainingDayState;

}

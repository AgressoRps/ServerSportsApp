package org.communis.serversportsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "training_day_content")
public class TrainingDayContent {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_training_day")
    private TrainingDay trainingDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;

    @Column(name = "number_repetitions")
    private Short numberRepetitions;

}

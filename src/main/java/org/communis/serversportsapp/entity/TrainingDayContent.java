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

    @Column(name = "id_training_day")
    private Long trainingDayID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;

    @Column(name = "number_repetitions")
    private Short numberRepetitions;

}

package org.communis.serversportsapp.entity;

import lombok.Data;
import org.communis.serversportsapp.enums.ExerciseTimeState;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "id_training_location")
    private Short trainingLocationID;

    @Column(name = "exercise_name")
    private String name;

    @Column(name = "photo_name")
    private String photoName;

    @Enumerated(EnumType.STRING)
    @Column(name = "on_time")
    private ExerciseTimeState exerciseTimeState;

}

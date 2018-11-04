package org.communis.serversportsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "training_location")
public class TrainingLocation {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "location_name")
    private String name;

}

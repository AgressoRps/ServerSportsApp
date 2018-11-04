package org.communis.serversportsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "day")
public class Day {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "day_name")
    private String name;

}

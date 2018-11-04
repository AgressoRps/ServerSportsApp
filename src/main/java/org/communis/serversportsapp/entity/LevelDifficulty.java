package org.communis.serversportsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "level_difficulty")
public class LevelDifficulty {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "level_name")
    private String name;

    @Column(name = "lead_time")
    private Short time;

    @Column(name = "coefficient")
    private Float coefficient;

}

package org.communis.serversportsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "progress")
public class Progress {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "progress_name")
    private String name;

}

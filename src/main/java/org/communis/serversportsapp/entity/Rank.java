package org.communis.serversportsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rank")
public class Rank {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rank_name")
    private String name;

}

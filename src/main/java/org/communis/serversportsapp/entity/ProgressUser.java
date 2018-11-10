package org.communis.serversportsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "progress_user")
public class ProgressUser {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_user")
    private Long userID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_progress")
    private Progress progress;

}

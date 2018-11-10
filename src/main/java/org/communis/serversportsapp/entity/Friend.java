package org.communis.serversportsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "friend")
public class Friend {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_user")
    private Long userID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_friend")
    private UserApp friend;

}

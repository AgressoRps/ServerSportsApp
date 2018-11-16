package org.communis.serversportsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_firebase")
public class UserFirebase {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "is_anonymous")
    private Boolean isAnonymous;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "email")
    private String email;
}

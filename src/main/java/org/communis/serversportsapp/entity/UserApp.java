package org.communis.serversportsapp.entity;

import lombok.Data;
import org.communis.serversportsapp.enums.UserAppRole;
import org.communis.serversportsapp.enums.UserState;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_app")
public class UserApp {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserAppRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private UserState userState;
}

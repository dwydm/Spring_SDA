package com.example.springjpaexample.model;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class User {

    public User(String firstName, String lastName, String login, String password, RoleType role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String firstName;

    @Setter
    @Column(nullable = false)
    private String lastName;

    @Setter
    @Column(nullable = false, unique = true)
    private String login;

    @Setter
    private String password;
    @Setter
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public enum RoleType {
        ROLE_USER, ROLE_ADMIN
    }

}


package com.example.javaclockbackend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @Column(unique=true)
    // I expect JPA Spring to throw error for duplicated username.
    // For now, it haven't worked, so I check duplication manually in register controller
    private String username;

    private String password;
    private String name;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

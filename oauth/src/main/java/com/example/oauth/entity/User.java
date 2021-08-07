package com.example.oauth.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "isActive")
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    public Role role;

}

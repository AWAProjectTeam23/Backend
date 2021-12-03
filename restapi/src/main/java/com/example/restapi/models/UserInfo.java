package com.example.restapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "userinfo")
public class UserInfo {

    @Id
    @Column(name = "user_uuid")
    private UUID user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "userinfo")
    @JsonBackReference
    @JsonIgnore
    public Set<Orders> orders;

    public UserInfo() {}

    public UserInfo(UUID user_id, String username, String password, Role role) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() { return role; }

    public String getPassword() { return password; }

    public UUID getUser_id() {
        return user_id;
    }
}

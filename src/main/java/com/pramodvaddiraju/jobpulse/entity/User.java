package com.pramodvaddiraju.jobpulse.entity;

import jakarta.persistence.*;

// JPA annotation to mark this as a database entity
@Entity
@Table(name="users")
public class User {

    @Id
    // Auto-generated primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Used for login. Must be unique
    @Column(nullable = false, unique = true)
    private String email;

    // Will store hashed password
    @Column(nullable = false)
    private String password;

    // e.g., "USER", "ADMIN" — used for authorization
    @Column(nullable = false)
    private String role;


    // Constructors

    public User(){

    }

    // No Args constructor
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // To String: Here we dont include password as we should not expose the password due to security reasons.

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

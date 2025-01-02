package com.kilo.klio.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="user", schema="public")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;

    @Column(name="first_name", nullable=false, length=50)
    private String firstName; 

    @Column(name="last_name", nullable=false, length=50)
    private String lastName;

    @Column(name="password", nullable=false, length=255)
    private String password;

    @Column(name="email", nullable=false, length=100, unique=true)
    private String email;

    @Column(name="budget", precision=10, scale=2)
    private BigDecimal budget;

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}

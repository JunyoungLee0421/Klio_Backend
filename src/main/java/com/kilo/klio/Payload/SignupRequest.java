package com.kilo.klio.Payload;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;

public class SignupRequest {

    private String fname;
    private String lname;
    private String email;
    private String password;
    private BigDecimal budget;

    // Default Constructor
    public SignupRequest() {
    }

    // Constructor for convenience
    public SignupRequest(String fname, String lname, String email, String password, BigDecimal budget) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.budget = budget;
    }

    // Getters and Setters

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public BigDecimal getBudget() {
        return budget;
    }

    @JsonSetter("budget")
    public void setBudget(Number budget) {
        if (budget != null) {
            // Convert the Number to a BigDecimal
            this.budget = BigDecimal.valueOf(budget.doubleValue());
        } else {
            this.budget = null;
        }
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", budget=" + budget +
                '}';
    }
}

package com.mytrandingai.ai_trading_platform.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Entity(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "Email is required ")
    @Email(message="Email should be valid")
    @Column(unique = true ,nullable = false)
    private String emailid;

    @NotBlank(message = "password is required")
    private String password;

    private double balance;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<UserStock> userStocks;

    // No-arg constructor
    public User() {}

    // Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmailid() {
        return emailid;
    }
    public String getPassword() {
        return password;
    }
    public double getBalance() {
        return balance;
    }
    public List<UserStock> getUserStocks() {
        return userStocks;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String emailid) {
        this.emailid = emailid;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setUserStocks(List<UserStock> userStocks) {
        this.userStocks = userStocks;
    }
}

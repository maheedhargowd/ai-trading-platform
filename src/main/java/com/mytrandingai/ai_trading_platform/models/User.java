package com.mytrandingai.ai_trading_platform.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Entity(name="users")
public class User {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank(message = "name is required")
    private String name ;

    @NotBlank(message = "Email is required ")
    @Email(message="Email should be valid")
    @Column(unique = true ,nullable = false)
    private String emailid;

    @NotBlank(message = "password is required")
    private String password;

    private double balance;

    //no-arg constructor 

    public User(){}

    //getters 

    public String getName(){
        return this.name;
    }
    
    public String getEmailid(){
        return this.emailid;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public double getBalance(){
        return this.balance;
    }

    //setters

    public void setName(String name){
        this.name=name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setEmail(String emailid){
        this.emailid=emailid;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }




}

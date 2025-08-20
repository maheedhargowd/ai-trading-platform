package com.mytrandingai.ai_trading_platform.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserStock {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable=false)
    private String stockSymbol;

    @Column(nullable=false)
    private Double quantity;

 
    //no-arg constructor 
    public void UserStocks(){};

    //getters

    public Long getId(){
        return Id;
    
    }
    
    public String getStockSymbol(){
        return stockSymbol;
    
    }

    public Double getQuantity(){
        return quantity;
    
    }

    //setters

    public void setId(Long Id){
        this.Id=Id;
    }
    public void setStockSymbol(String stockSymbol){
        this.stockSymbol=stockSymbol;
    }
    public void setQuantity(Double quantity){
        this.quantity=quantity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }



    





}

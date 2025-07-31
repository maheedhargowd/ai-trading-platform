package com.mytrandingai.ai_trading_platform.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Trade {      
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)       // 1
    private Long id;   
    
    @NotBlank(message="symbol is manditory")// 2
    private String symbol;  
    
    @NotNull(message="quantity is manditory")
    @Min(value =1 , message="quantity must be atlesst 1")// 3 
    private int quantity;           // 4

    public Trade(){}
    // Constructor
    public Trade(Long id, String symbol, int quantity) {      // 5
        this.id = id;
        this.symbol = symbol;
        this.quantity = quantity;
    }
    // Getters and setters
    public Long getId() { return id; }                        // 6
    public void setId(Long id) { this.id = id; }
    public String getSymbol() { return symbol; }              // 7
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public int getQuantity() { return quantity; }             // 8
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

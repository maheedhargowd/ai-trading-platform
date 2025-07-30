package com.mytrandingai.ai_trading_platform.models;




public class Trade {                // 1
    private Long id;                // 2
    private String symbol;          // 3
    private int quantity;           // 4

    public Trade(){

    }
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

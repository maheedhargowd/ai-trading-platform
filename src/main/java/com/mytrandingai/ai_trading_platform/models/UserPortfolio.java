package com.mytrandingai.ai_trading_platform.models;

import java.util.HashMap;
import java.util.Map;

public class UserPortfolio {
    private Long userId;
    private double balance;
    private Map<String, Double> stocksOwned = new HashMap<>();
    private Double totalInvested;
    private Double totalProfit;
    private Double totalLoss;

    private Double totalStocksOwned;









    //getters
    public double getBalance(){
        return balance;
    }
    public Double getTotalStocksOwned() {
        return totalStocksOwned;
    }
    public Map<String, Double> getStocksOwned() {
        return stocksOwned;
    }
  
    public Long getuserId(){
        return userId;
    }

    public Double getTotalInvested(){
        return totalInvested;
    }

    public Double getTotalProfit(){
        return totalProfit;
    }
    public Double getTotalLoss(){
        return totalLoss;
    }
    //settters

    public void setTotalStocksOwned(Double totalStocksOwned) {
        this.totalStocksOwned = totalStocksOwned;
    }
    public void setStocksOwned(Map<String, Double> stocksOwned) {
        this.stocksOwned = stocksOwned;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public void setTotalInvested(Double totalInvested){
        this.totalInvested = totalInvested;
    }
    public void setTotalProfit(Double totalProfit){
        this.totalProfit = totalProfit;
    }
    public void setTotalLoss(Double totalLoss){
        this.totalLoss=totalLoss;
    }
}
 
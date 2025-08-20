package com.mytrandingai.ai_trading_platform.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a stock transaction made by a user.
 */
@Entity
public class Transaction {

    // ==============================
    // Fields
    // ==============================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name="transaction_type")
    private String transactionType; //BUY or SELL

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "stock_symbol")
    private String stockSymbol;

    @Column(name = "number_of_stocks")
    private Double numberOfStocks;

    @Column(name = "stock_price_at_transaction")
    private Double stockPriceAtTransaction;

    @Column(name = "total_amount_in_usd")
    private Double totalAmountInUSD;


 

    // ==============================
    // Constructors
    // ==============================

    public Transaction() {
        // Default no-argument constructor
    }

    // ==============================
    // Getters
    // ==============================

    public Long getId() {
        return id;
    }
    
    public Long getUserId() {
        return userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public Double getNumberOfStocks() {
        return numberOfStocks;
    }

    public Double getStockPriceAtTransaction() {
        return stockPriceAtTransaction;
    }

    public Double getTotalAmountInUSD() {
        return totalAmountInUSD;
    }



    public String getTransactionType(){
        return transactionType;
    }
    // ==============================
    // Setters
    // ==============================

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public void setNumberOfStocks(double numberOfStocks) {
        this.numberOfStocks = numberOfStocks;
    }

    public void setStockPriceAtTransaction(double stockPriceAtTransaction) {
        this.stockPriceAtTransaction = stockPriceAtTransaction;
    }

    public void setTotalAmountInUSD(double totalAmountInUSD) {
        this.totalAmountInUSD = totalAmountInUSD;
    }



    public void setTransactionType(String transactionType){
        this.transactionType=transactionType;
    }
}

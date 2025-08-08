package com.mytrandingai.ai_trading_platform.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String stockSymbol;
    private String companyName;
    private String sector;
    private double priceInUSD;
    private double marketCapBiilionUSD;
    private double volumeInMillions;
    private double PERatio;

    // No-argument constructor
    public Stock() {}

    // Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }
    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getPriceInUSD() {
        return priceInUSD;
    }
    public void setPriceInUSD(double priceInUSD) {
        this.priceInUSD = priceInUSD;
    }

    public double getMarketCapBiilionUSD() {
        return marketCapBiilionUSD;
    }
    public void setMarketCapBiilionUSD(double marketCapBiilionUSD) {
        this.marketCapBiilionUSD = marketCapBiilionUSD;
    }

    public double getVolumeInMillions() {
        return volumeInMillions;
    }
    public void setVolumeInMillions(double volumeInMillions) {
        this.volumeInMillions = volumeInMillions;
    }

    public double getPERatio() {
        return PERatio;
    }
    public void setPERatio(double PERatio) {
        this.PERatio = PERatio;
    }
}

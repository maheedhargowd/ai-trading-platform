package com.mytrandingai.ai_trading_platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytrandingai.ai_trading_platform.models.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    // No need to add anything – JpaRepository provides findAll()

    Stock findBySymbol(String symbol );
}

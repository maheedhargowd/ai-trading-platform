package com.mytrandingai.ai_trading_platform.repositories;

import com.mytrandingai.ai_trading_platform.models.Trade;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade , Long>{

    
}

package com.mytrandingai.ai_trading_platform.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytrandingai.ai_trading_platform.models.Transaction;




public interface TransactionRepository extends JpaRepository<Transaction , Long> {
    List<Transaction> findByUserId(Long userId);
    List<Transaction> findByUserIdAndStockSymbol(Long userId, String stockSymbol);
    // String findByStockSymbol(String symbol);
    
}

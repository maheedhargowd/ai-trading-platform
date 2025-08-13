package com.mytrandingai.ai_trading_platform.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mytrandingai.ai_trading_platform.models.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction , Long> {
    
}

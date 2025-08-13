package com.mytrandingai.ai_trading_platform.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrandingai.ai_trading_platform.models.Transaction;
import com.mytrandingai.ai_trading_platform.repositories.TransactionRepository;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}

package com.mytrandingai.ai_trading_platform.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrandingai.ai_trading_platform.models.Transaction;
import com.mytrandingai.ai_trading_platform.repositories.TransactionRepository;

@Service
public class StockService {


    @Autowired
    TransactionRepository transactionRepository;

 

    public String buyStock(Transaction transaction){


        Transaction savedTransaction = transactionRepository.save(transaction);
        if(savedTransaction ==null){

            return "failed to buy stack !";
        }else{
        return "stack bought successfully !";
        }
    }

    public String sellStock(Transaction transaction){

        Transaction savedTransactoin  = transactionRepository.save(transaction);

        if(savedTransactoin == null){
            return "failed to sell stock !";
        }else{
            return "stock sold successfully !";
        }
    }
    
}

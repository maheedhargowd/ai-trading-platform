package com.mytrandingai.ai_trading_platform.services;



import java.util.ArrayList;
import java.util.List;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrandingai.ai_trading_platform.models.Trade;

import com.mytrandingai.ai_trading_platform.repositories.TradeRepository;

@Service
public class TradeService  {

    private final TradeRepository tradeRepository;

    //constructor injection 
    @Autowired
    public TradeService(TradeRepository tradeRepository){
        this.tradeRepository=tradeRepository;
    }


    public String saveTrade(Trade trade){

        tradeRepository.save(trade);
        return "Trade saved successfully";
    }

    public String updateTrade(Long id , Trade tradeDetails){

        Trade trade  =  tradeRepository.findById(id).orElseThrow(() -> new  RuntimeException("Trade not found"));
        trade.setSymbol(tradeDetails.getSymbol());
        trade.setQuantity(tradeDetails.getQuantity());
        tradeRepository.save(trade);
        return "trade updated successfully";



    }
    public void deleteTrade(Long id){

        if(!tradeRepository.existsById(id)){
            throw new RuntimeException("Trade not found");
        }
        tradeRepository.deleteById(id);
    }

    public List<Trade> getAllTrades(){


        return tradeRepository.findAll(); 
    }
    
}




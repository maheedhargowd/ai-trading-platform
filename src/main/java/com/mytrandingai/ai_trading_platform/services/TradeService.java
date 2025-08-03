package com.mytrandingai.ai_trading_platform.services;



import java.util.ArrayList;
import java.util.List;

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
    public List<Trade> getAllTrades(){


        return tradeRepository.findAll(); 
    }

    public Trade saveTrade(Trade trade){
        return tradeRepository.save(trade);
    }

    public Trade updateTrade(Long id , Trade tradeDetails){

        Trade trade  =  tradeRepository.findById(id).orElseThrow(() -> new  RuntimeException("Trade not found"));
        trade.setSymbol(tradeDetails.getSymbol());
        trade.setQuantity(tradeDetails.getQuantity());
        return tradeRepository.save(trade);




    }
    public void deleteTrade(Long id){

        if(!tradeRepository.existsById(id)){
            throw new RuntimeException("Trade not found");
        }
        tradeRepository.deleteById(id);
    }
    
}




package com.mytrandingai.ai_trading_platform.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mytrandingai.ai_trading_platform.models.Trade;

@Service
public class TradeService {


    public List<Trade> getAllTrades(){


                 
        List<Trade> trades = new ArrayList<>(); // 7
        trades.add(new Trade(134L, "AAPL", 10)); // 8
        trades.add(new Trade(2L, "GOOG", 5));  // 9
        return trades; 
    }
    
}




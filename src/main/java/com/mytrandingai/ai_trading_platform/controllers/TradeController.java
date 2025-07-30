package com.mytrandingai.ai_trading_platform.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;   // 1

import com.mytrandingai.ai_trading_platform.models.Trade;
import com.mytrandingai.ai_trading_platform.services.TradeService;

@RestController                                 // 2
@RequestMapping("/api/trades")                  // 3
public class TradeController {    
    
    
    private final TradeService tradeService;
    public TradeController(TradeService tradeService){
        this.tradeService=tradeService;
    }

    @GetMapping("/getalltrades")
    public List<Trade> getalltrades(){
       return  tradeService.getAllTrades();
    }    
    
                        
    

    

}


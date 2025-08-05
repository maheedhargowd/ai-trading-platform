package com.mytrandingai.ai_trading_platform.services ;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mock;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.mytrandingai.ai_trading_platform.models.Trade;
import com.mytrandingai.ai_trading_platform.repositories.TradeRepository;

public class TradeServicesTest {
    
    @Mock
    TradeRepository tradeRepository ;

    @InjectMocks
    TradeService tradeService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void saveTrade(){


        Trade trade = new Trade(null, "APPLE", 30);

        when(tradeRepository.save(trade)).thenReturn(trade);

        String result = tradeService.saveTrade(trade);

        assertEquals("Trade saved successfully", result);



    }


}

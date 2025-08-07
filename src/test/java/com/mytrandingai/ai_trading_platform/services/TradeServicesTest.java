package com.mytrandingai.ai_trading_platform.services ;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

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

    @Test
    void updateTrade(){

        Long id=1L;
        Trade existingtrade = new Trade(id, "APPLE", 30);
        Trade updatedTrade =  new Trade(id, "apple", 10);

        when(tradeRepository.findById(id)).thenReturn(Optional.of(existingtrade)); 

        String result =  tradeService.updateTrade(id, updatedTrade);

        assertEquals("trade updated successfully", result);
        assertEquals("apple", existingtrade.getSymbol());
        assertEquals(10,existingtrade.getQuantity());

        verify(tradeRepository).findById(id);
        verify(tradeRepository).save(existingtrade);



    }
    @Test
    void getAllTrades(){

        Trade trade1 = new Trade(1L ,"AAPL", 100);
        Trade trade2 = new Trade(2L ,"SMSNG", 300);
        List<Trade> expectedResult = Arrays.asList(trade1,trade2);


        when(tradeRepository.findAll()).thenReturn(expectedResult);


        List<Trade> actualResult = tradeService.getAllTrades();


        assertEquals(actualResult,expectedResult);
        assertEquals(2,actualResult.size());
        assertEquals("AAPL", actualResult.get(0).getSymbol());
        assertEquals("SMSNG",actualResult.get(1).getSymbol());



        verify(tradeRepository).findAll();

        
    }

    @Test
    void deleteTrade_WhenTradeExists_DeleteSuccessfully(){
        Long id=1L;
        
        when(tradeRepository.existsById(id)).thenReturn(true);

        tradeService.deleteTrade(id);
        
        verify(tradeRepository).deleteById(id);

    }
    @Test
    void deleteTrade_WhenTradeDoesnotExists_throwsException(){

        Long id =1L;

        when(tradeRepository.existsById(id)).thenReturn(false);

        RuntimeException ex = assertThrows(RuntimeException.class , () -> tradeService.deleteTrade(id));

        assertEquals(("Trade not found"), ex.getMessage());

        verify(tradeRepository, never()).deleteById(any());



    }



   




}

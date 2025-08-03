package com.mytrandingai.ai_trading_platform.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;   // 1

import com.mytrandingai.ai_trading_platform.models.Trade;
import com.mytrandingai.ai_trading_platform.services.TradeService;

import jakarta.validation.Valid;

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

    @PostMapping("/savetrade")
    public ResponseEntity<Trade> saveTrade(@Valid @RequestBody Trade trade){
        Trade saved = tradeService.saveTrade(trade);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable Long id , @RequestBody @Valid Trade trade){

        Trade updated = tradeService.updateTrade(id,trade);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrade(@PathVariable Long id){
        tradeService.deleteTrade(id);
        return ResponseEntity.noContent().build();
    }



    // Global exception handler for validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ");
        });

        return ResponseEntity.badRequest().body(errors.toString());
    }
    
                        
    

    

}


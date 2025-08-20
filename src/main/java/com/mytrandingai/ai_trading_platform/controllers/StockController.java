package com.mytrandingai.ai_trading_platform.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytrandingai.ai_trading_platform.models.Stock;
import com.mytrandingai.ai_trading_platform.models.Transaction;
import com.mytrandingai.ai_trading_platform.repositories.StockRepository;
import com.mytrandingai.ai_trading_platform.services.StockService;



@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockService stockService;

    @GetMapping("/getallstocks")
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> result = stockRepository.findAll();
        return ResponseEntity.ok(result);
    }


    @PostMapping("/buystock")
    public  ResponseEntity<String> buyStock(@RequestBody Transaction transaction){
        String result = stockService.buyStock(transaction);
        if(result.equals("stock bought successfully !")){
           return ResponseEntity.ok().body(result);
        }else if(result.equals("failed to buy stock !")){
           return  ResponseEntity.badRequest().body(result);
        }return  ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/sellstock")
    public ResponseEntity<String> sellStock(@RequestBody Transaction transaction){
        
        String result = stockService.sellStock(transaction);
        if(result.equals("stock sold successfully !")){
           return  ResponseEntity.ok().body(result);
        }else if(result.equals("failed to sell stock !")){
            return  ResponseEntity.badRequest().body(result);
        }else if(result.equals("Error occured while selling stock !")){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.badRequest().body(result);

        
    }
        
}



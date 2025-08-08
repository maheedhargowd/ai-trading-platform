package com.mytrandingai.ai_trading_platform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mytrandingai.ai_trading_platform.models.Stock;
import com.mytrandingai.ai_trading_platform.repositories.StockRepository;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/getallstocks")
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}

package com.mytrandingai.ai_trading_platform.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrandingai.ai_trading_platform.models.Transaction;
import com.mytrandingai.ai_trading_platform.models.UserPortfolio;
import com.mytrandingai.ai_trading_platform.repositories.TransactionRepository;

@Service
public class PortfolioService {
 
    @Autowired
    TransactionRepository transactionRepository;
    
    public UserPortfolio getUserPortfolio(Long userId){
       
        UserPortfolio portfolio = new UserPortfolio();
        portfolio.setUserId(userId);
        
        List<Transaction> userTransactions = transactionRepository.findByUserId(userId);
       

        Map<String, Double> totalSharesOwned = new HashMap<>();
        Map<String, Double> totalInvestedAmount = new HashMap<>();


       

        


        for (Transaction txn : userTransactions) {
            String symbol = txn.getStockSymbol();
            double qty = txn.getNumberOfStocks();
            double amount = txn.getTotalAmountInUSD();
            
            totalSharesOwned.putIfAbsent(symbol, 0.0);
            totalInvestedAmount.putIfAbsent(symbol, 0.0);
            
            if ("BUY".equalsIgnoreCase(txn.getTransactionType())) {
                totalSharesOwned.put(symbol, totalSharesOwned.get(symbol) + qty);
                totalInvestedAmount.put(symbol, totalInvestedAmount.get(symbol) + amount);
            } else if ("SELL".equalsIgnoreCase(txn.getTransactionType())) {
                totalSharesOwned.put(symbol, totalSharesOwned.get(symbol) - qty);
            }
        }   
        
        // Calculate total invested across all symbols
        double totalInvested = 0.0;
        for (Double investedAmount : totalInvestedAmount.values()) {
            totalInvested += investedAmount;
        }
         Map<String, Double> holdings = totalSharesOwned.entrySet().stream()
            .filter(entry -> entry.getValue() != null && entry.getValue() > 0)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        // Set values in the portfolio object
        portfolio.setStocksOwned(holdings);  
        portfolio.setTotalInvested(totalInvested);
        portfolio.setTotalProfit(0.0);  // We'll calculate this in the next step
        portfolio.setTotalLoss(0.0);  // We'll calculate this in the next step
        
                // Step 1: Calculate totalSharesBought per symbol
        Map<String, Double> totalSharesBought = new HashMap<>();
        for (Transaction txn : userTransactions) {
            if ("BUY".equalsIgnoreCase(txn.getTransactionType())) {
                String symbol = txn.getStockSymbol();
                double qty = txn.getNumberOfStocks();
                totalSharesBought.put(symbol, totalSharesBought.getOrDefault(symbol, 0.0) + qty);
            }
        }

        // Step 2: Calculate average cost per share
        Map<String, Double> averageCostPerShare = new HashMap<>();
        for (String symbol : totalInvestedAmount.keySet()) {
            double invested = totalInvestedAmount.get(symbol);
            double bought = totalSharesBought.get(symbol);
            averageCostPerShare.put(symbol, invested / bought);
        }

        // Step 3: Calculate totalProfit and totalLoss
        double totalProfit = 0.0;
        double totalLoss = 0.0;
        for (Transaction txn : userTransactions) {
            if ("SELL".equalsIgnoreCase(txn.getTransactionType())) {
                String symbol = txn.getStockSymbol();
                double sellPrice = txn.getStockPriceAtTransaction();
                double qty = txn.getNumberOfStocks();
                double avgCost = averageCostPerShare.get(symbol);
                
                double pnl = (sellPrice - avgCost) * qty;
                if (pnl >= 0) totalProfit += pnl;
                else totalLoss += -pnl;
            }
        }

        // Step 4: Set values in portfolio object
        portfolio.setTotalProfit(totalProfit);
        portfolio.setTotalLoss(totalLoss);


        return portfolio;
    }
}

package com.mytrandingai.ai_trading_platform.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrandingai.ai_trading_platform.models.Stock;
import com.mytrandingai.ai_trading_platform.models.Transaction;
import com.mytrandingai.ai_trading_platform.models.User;
import com.mytrandingai.ai_trading_platform.models.UserStock;
import com.mytrandingai.ai_trading_platform.repositories.StockRepository;
import com.mytrandingai.ai_trading_platform.repositories.TransactionRepository;
import com.mytrandingai.ai_trading_platform.repositories.UserRepository;
import com.mytrandingai.ai_trading_platform.repositories.UserStockRepository;

@Service
public class StockService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private UserStockRepository userStockRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public String buyStock(Transaction transaction) {

        Long userId = transaction.getUserId();
        String stockSymbol = transaction.getStockSymbol();
        Double numberOfStocks = transaction.getNumberOfStocks();

        
        
        // a) Fetch user and stock
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        Stock stock = stockRepository.findBySymbol(stockSymbol);
        if (stock == null) throw new RuntimeException("Stock not found");

        // b) Calculate total cost
        Double currentPrice = stock.getCurrentPrice();
        Double totalAmount = currentPrice * numberOfStocks;
        String ComapanyName = stock.getCompanyName();
        // c) Check user balance
        if (user.getBalance() < totalAmount) {
            return "Not enough balance!";
        }

        // d) Save transaction
        Transaction txn = new Transaction();
        txn.setUserId(userId);
        txn.setCompanyName(ComapanyName);
        txn.setStockSymbol(stockSymbol);
        txn.setTransactionType("BUY");
        txn.setNumberOfStocks(numberOfStocks);
        txn.setStockPriceAtTransaction(currentPrice);
        txn.setTotalAmountInUSD(totalAmount);
        transactionRepository.save(txn);

        // e) Update user holdings (portfolio)
        UserStock userStock = userStockRepository.findByUserAndStockSymbol(user, stockSymbol);
        if (userStock == null) {
            userStock = new UserStock();
            userStock.setUser(user);
            userStock.setStockSymbol(stockSymbol);
            userStock.setQuantity(numberOfStocks);
        } else {
            userStock.setQuantity(userStock.getQuantity() + numberOfStocks);
        }
        userStockRepository.save(userStock);

        // f) Update user balance
        user.setBalance(user.getBalance() - totalAmount);
        userRepository.save(user);

        return "Stock bought successfully!";
    }


    public String sellStock(Transaction transaction) {
    Long userId = transaction.getUserId();
    String stockSymbol = transaction.getStockSymbol();
    Double numberOfStocks = transaction.getNumberOfStocks();

    // a) Fetch user and stock
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));
    Stock stock = stockRepository.findBySymbol(stockSymbol);
    if (stock == null) {
        throw new RuntimeException("Stock not found");
    }

    // b) Check if user owns enough shares
    UserStock userStock = userStockRepository.findByUserAndStockSymbol(user, stockSymbol);
    String ComapanyName = stock.getCompanyName();
    if (userStock == null || userStock.getQuantity() < numberOfStocks) {
        return "Insufficient stock to sell!";
    }

    // c) Calculate total sell amount
    Double currentPrice = stock.getCurrentPrice();
    Double totalAmount = currentPrice * numberOfStocks;
    

    // d) Save transaction for the sell
    Transaction txn = new Transaction();
    txn.setUserId(userId);
    txn.setCompanyName(ComapanyName);
    txn.setStockSymbol(stockSymbol);
    txn.setTransactionType("SELL");
    txn.setNumberOfStocks(numberOfStocks);
    txn.setStockPriceAtTransaction(currentPrice);
    txn.setTotalAmountInUSD(totalAmount);
    transactionRepository.save(txn);

    // e) Update user holdings (decrease quantity)
    userStock.setQuantity(userStock.getQuantity() - numberOfStocks);
    if (userStock.getQuantity() <= 0) {
        // Remove the UserStock record completely if the user no longer holds any shares
        userStockRepository.delete(userStock);
    } else {
        userStockRepository.save(userStock);
    }

    // f) Update user balance (add money received from sale)
    user.setBalance(user.getBalance() + totalAmount);
    userRepository.save(user);

    return "Stock sold successfully!";
}

}


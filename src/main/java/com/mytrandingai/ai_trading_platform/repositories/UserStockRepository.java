package com.mytrandingai.ai_trading_platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytrandingai.ai_trading_platform.models.User;
import com.mytrandingai.ai_trading_platform.models.UserStock;

public interface  UserStockRepository extends JpaRepository<UserStock, Long>{
    UserStock findByUserAndStockSymbol(User user , String stockSymbol);

}

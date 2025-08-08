package com.mytrandingai.ai_trading_platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytrandingai.ai_trading_platform.models.User;

public interface UserRepository extends JpaRepository<User,Long>{

        boolean existsByEmailid(String emailid);

        User findByEmailid(String emailid);

}

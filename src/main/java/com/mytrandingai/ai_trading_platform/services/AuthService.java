package com.mytrandingai.ai_trading_platform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytrandingai.ai_trading_platform.models.User;
import com.mytrandingai.ai_trading_platform.repositories.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {

    @Autowired
    private  UserRepository userRepository;

    private final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

    public String singUp(User user ){

        //check if user already exists in db 
        if(userRepository.existsByEmailid(user.getEmailid())){
            return "Email already taken ";
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "signed up successfully !";
    }

    public String login(String emailid , String password ){

        User existingUser = userRepository.findByEmailid(emailid);

        if(existingUser == null){
            return "User doesnot exist ";
        }

        if(!passwordEncoder.matches(password , existingUser.getPassword())){
            return "Invalid credentails";
        }
        return "logged in successfully !";
    }


    


}

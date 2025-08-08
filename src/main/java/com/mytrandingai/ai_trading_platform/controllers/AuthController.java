package com.mytrandingai.ai_trading_platform.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mytrandingai.ai_trading_platform.models.User;
import com.mytrandingai.ai_trading_platform.services.AuthService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody User user){


        String result =  authService.singUp(user);

        if(result.equals("signed up successfully !")){
           return  ResponseEntity.status(201).body(result);
        }

        return ResponseEntity.badRequest().body(result);



       
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){

        String result = authService.login(user.getEmailid(), user.getPassword());

        if(result.equals("logged in successfully !")){
            ResponseEntity.ok(result);
        }

        
        return ResponseEntity.status(401).body(result);
    }
    
}

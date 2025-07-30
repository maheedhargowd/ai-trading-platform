package com.mytrandingai.ai_trading_platform.controllers;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public String sayhello(){
        return "hello";
    }
    
}

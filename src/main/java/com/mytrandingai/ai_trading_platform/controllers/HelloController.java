package com.mytrandingai.ai_trading_platform.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api")
    public String helloworld() {
        return "Hello World!";
    }
}

package com.codebloom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

    @GetMapping("/welcome")
    public String Welcome(){
        return "Welcome to CodeBloom";
    }

    @GetMapping("/text")
    public String Greeting(){
        return "Hi How are you doing !!";
    }

    @GetMapping("/nonSecure")
    public String nonSecure(){
        return "Hi This is non secure endpoint. You have the access  !!";
    }
}

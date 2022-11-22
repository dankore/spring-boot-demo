package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.GreetingService;

@RestController
public class MainController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String getGreeting(){
        return "HelloWorld";
    }

    // Exact same thing as above
    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting2() {
        return ResponseEntity.ok("HelloWorld");
    }

    @GetMapping("/greetingService")
    @ResponseStatus(HttpStatus.OK)
    public String getServicetGreeting(){
        return greetingService.generateGreeting();
    }
}

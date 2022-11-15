package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configs.GreetingConfig;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingService {

    @Autowired
    private GreetingConfig greetingConfig;

    public String generateGreeting() {
        log.info("Logging with my lombok @slf4j annotation!");
        return "Hello " + greetingConfig.getGreetingName();
    }

}

package com.example.springbootudemy.controllers;

import com.example.springbootudemy.config.CurrencyServiceConfig;
import com.example.springbootudemy.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfigController {

    @Autowired
    private CurrencyServiceConfig currencyServiceConfig;

    @GetMapping("/currency-config")
    public CurrencyServiceConfig getProperties() {
        return currencyServiceConfig;
    }
}

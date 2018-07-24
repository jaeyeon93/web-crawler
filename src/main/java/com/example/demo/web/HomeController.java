package com.example.demo.web;

import com.example.demo.dto.KeyboardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HomeController {
    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/keyboard")
    public KeyboardDto keyboard(@Valid @RequestBody String stockName) {
        KeyboardDto keyboard = new KeyboardDto(stockName);
        return keyboard;
    }
}

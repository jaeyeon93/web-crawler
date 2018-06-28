package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {
    public static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @GetMapping("/")
    public String index() {
        logger.info("index method called");
        return "/index";
    }
}

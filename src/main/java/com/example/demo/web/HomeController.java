package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {
        logger.info("index method called");
        return "/index";
    }

    @GetMapping("/show")
    public String second() {
        logger.info("index2 file load");
        return "/index3";
    }
}

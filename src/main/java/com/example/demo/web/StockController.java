package com.example.demo.web;

import com.example.demo.dao.Research;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/stock")
public class StockController {
    public static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @Resource(name = "research")
    private Research research;

    @PostMapping("")
    public String research(String stockName) {
        logger.info("post method called : {}", stockName);
        research.getDriver().get("http://finance.daum.net/");
        research.search(stockName);
        return "redirect:/";
    }

}

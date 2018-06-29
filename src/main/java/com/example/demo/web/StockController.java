package com.example.demo.web;

import com.example.demo.dao.Research;
import com.example.demo.domain.Stock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Resource(name = "stock")
    private Stock stock;

    @PostMapping("")
    public String research(String stockName, Model model) {
        logger.info("research info : {}", research.toString());
        research.search(stockName);
        research.searchDetail(stockName);
        Stock stock = research.make(stockName);
        logger.info("stock info : {}", stock.toString());
        return "redirect:/stock";
    }

    @GetMapping("")
    public String showInfo(Model model) {
        logger.info("showinfo stock : {}");
        logger.info("showInfo method called");
        model.addAttribute("stock", stock);
        return "/index3";
    }

}

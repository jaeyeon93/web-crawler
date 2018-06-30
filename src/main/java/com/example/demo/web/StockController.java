package com.example.demo.web;

import com.example.demo.dao.Research;
import com.example.demo.domain.Stock;
import com.example.demo.service.StockService;
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

    @Resource(name = "stockService")
    private StockService stockService;

    @PostMapping("")
    public String research(String stockName) throws Exception {
        stockService.add(stockName);
        return "redirect:/stock";
    }

    @GetMapping("")
    public String showInfo(Model model) {
        model.addAttribute("stock", stockService.findAll());
        return "/index3";
    }
}

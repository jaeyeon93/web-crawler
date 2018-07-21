package com.example.demo.web;

import com.example.demo.domain.Stock;
import com.example.demo.service.StockService;
import org.apache.xpath.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockController {
    public static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @Resource(name = "stockService")
    private StockService stockService;

    @PostMapping("")
    public String research(String stockName) throws Exception {
        stockService.add(stockName);
        return "redirect:/stock";
    }

//    @GetMapping("")
//    public String list(Model model) {
//        model.addAttribute("stock", stockService.findAll());
//        return "/stock/showInfo";
//    }

    @GetMapping("")
    public @ResponseBody List<Stock> list(Model model) {
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    public String oneStockInfo(@PathVariable long id, Model model) {
        logger.info("controller called, id : {}", id);
        model.addAttribute("stock", stockService.findById(id));
        return "/stock/showInfo";
    }


    @PutMapping("/{id}")
    public void stockUpdate(@PathVariable long id, Model model) {
        logger.info("update method called");
//        stockService.update(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) throws Exception {
        logger.info("delete method called");
        stockService.delete(id);
    }
}

package com.example.demo.web;

import com.example.demo.domain.Stock;
import com.example.demo.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class ApiStockController {
    public static final Logger logger = LoggerFactory.getLogger(ApiStockController.class);

    @Resource(name = "stockService")
    private StockService stockService;

    private List<Stock> stocks;

    @PostMapping("")
    public ResponseEntity<Void> create(String stockName) throws Exception {
        logger.info("restcontroller called");
        stocks = stockService.add(stockName);
        logger.info("stocks info : {}", getStocks());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/stock" + stocks.get(0).getId()));
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Stock> list() {
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    public Stock show(@PathVariable long id) {
        return stockService.findById(id);
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}
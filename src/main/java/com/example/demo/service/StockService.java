package com.example.demo.service;

import com.example.demo.domain.Stock;
import com.example.demo.domain.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockService {
    public static final Logger logger = LoggerFactory.getLogger(StockService.class);

    @Resource(name = "stockRepository")
    private StockRepository stockRepository;

    public Stock add(Stock stock) {
        logger.info("stock added : {}", stock.toString());
        return stockRepository.save(stock);
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Stock findById(long id) {
        return stockRepository.findOne(id);
    }

    public Stock findByName(String name) {
        return stockRepository.findByName(name);
    }
}

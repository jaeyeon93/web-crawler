package com.example.demo.service;

import com.example.demo.dao.Research;
import com.example.demo.domain.Stock;
import com.example.demo.domain.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockService {
    public static final Logger logger = LoggerFactory.getLogger(StockService.class);

    @Resource(name = "stockRepository")
    private StockRepository stockRepository;

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Stock findById(long id) {
        return stockRepository.findOne(id);
    }

    public Stock findByName(String stockName) {
        logger.info("stockName on Service : {}", stockName);
        return stockRepository.findByName(stockName);
    }

    public Stock add(String stockName) throws Exception {
        logger.info("add method called : {}", stockName);
        Research research = new Research(stockName);
        if (checkMakingStock(stockName)) {
            logger.info("db에 존재함 : {}");
            Stock stock = research.update(stockRepository.findByName(stockName));
            logger.info("updated stock inforamtion on service : {}", stock.toString());
            return stockRepository.save(stock);
        }
        logger.info("DB에 {}이 존재하지 않음", stockName);
        return stockRepository.save(research.make());
    }

    public boolean checkMakingStock(String stockName) {
        logger.info("stockName : {} on checkMakingStock method", stockName);
        if (stockRepository.findByName(stockName) != null)
            return true;
        return false;
    }

    @Transactional
    public void delete(long id) throws Exception {
        logger.info("delete method called {}", id);
        stockRepository.delete(id);
    }
}

package com.example.demo.web;

import com.example.demo.domain.Stock;
import com.example.demo.support.test.AcceptanceTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ApiStockAcceptanceTest extends AcceptanceTest {
    private Stock stock;
    public static final Logger logger = LoggerFactory.getLogger(ApiStockAcceptanceTest.class);
//    @Before
//    public void setUp() {
//        stock = new Stock("삼성전자", "46,650", "536,450", "2,994,615억");
//    }

    @Test
    public void create() throws Exception {
//        stock = new Stock("삼성전자", "46,650", "536,450", "2,994,615억");
        String path = createResource("/api/stock", "삼성전자");
        logger.info("StockName on create method : {}", stock.getName());
        Stock stock2 = getResource(path, Stock.class);
        assertThat(getResource(path, Stock.class), is(stock2));
    }

    @Test
    public void listTest() throws Exception {
        ResponseEntity<String> response = template().getForEntity("/api/stock/list", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }
}

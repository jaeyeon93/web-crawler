package com.example.demo.web;

import com.example.demo.domain.Stock;
import com.example.demo.AcceptanceTest;
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

    @Test
    public void create() throws Exception {
        String path = createResource("/api/stock", "삼성전기,호텔신라,현대차");
        logger.info("path : {}", path);
        stock = getResource(path, Stock.class);
        logger.info("info : {}", stock.toString());
    }

//    @Test
//    public void 여러개() throws Exception {
//        String path = createResource("/api/stock", "삼성전기,신세계,호텔신라");
//    }

    @Test
    public void listTest() throws Exception {
        ResponseEntity<String> response = template().getForEntity("/api/stock/list", String.class);
        logger.info("body is {}", response.getBody());
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void show() throws Exception {
        ResponseEntity<String> response = template().getForEntity("/api/stock/1", String.class);
        logger.info("Header is {}", response.getHeaders());
        logger.info("body is {}", response.getBody());
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }
}

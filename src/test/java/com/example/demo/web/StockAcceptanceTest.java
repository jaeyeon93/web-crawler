package com.example.demo.web;

import com.example.demo.AcceptanceTest;
import com.example.demo.HtmlFormDataBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StockAcceptanceTest extends AcceptanceTest {
    public static final Logger logger = LoggerFactory.getLogger(StockAcceptanceTest.class);

    @Test
    public void addStock() throws Exception {
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodeForm()
                .addParameter("stockName", "SK하이닉스").build();
        logger.info("request : {}", request.getBody());
        ResponseEntity<String> response = template().postForEntity("/stock", request, String.class);
        logger.info("response : {}", request.getBody());
        assertThat(response.getStatusCode(), is(HttpStatus.FOUND));
    }

    @Test
    public void 여러개get() throws Exception {
        ResponseEntity<String> response = template().getForEntity("/stock/이마트,한진칼,현대차,NAVER,카카오", String.class);
        logger.info("response : {}", response.getBody());
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void showStock() throws Exception {
        ResponseEntity<String> response = template().getForEntity("/stock/1", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void showStockByName() throws Exception {
        ResponseEntity<String> response = template().getForEntity("/stock/삼성전자", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }
}

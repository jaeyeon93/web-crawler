package com.example.demo;


import com.example.demo.domain.Stock;
import com.example.demo.domain.StockRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AcceptanceTest {
    private static final String SAMSUNG = "삼성전자";

    @Autowired
    protected TestRestTemplate template;

    @Autowired
    protected StockRepository stockRepository;

    public TestRestTemplate template() {
        return template;
    }

    protected Stock findByStockName(String stockName) {
        return stockRepository.findByName(stockName);
    }

    protected String createResource(String path, Object bodyPayload) {
        ResponseEntity<String> response = template().postForEntity(path, bodyPayload, String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
        return response.getHeaders().getLocation().getPath();
    }

    protected  <T> T getResource(String location, Class<T> responseType) {
        return template().getForObject(location, responseType);
    }

    protected ResponseEntity<String> getResource(String location) {
        return template().getForEntity(location, String.class);
    }
}

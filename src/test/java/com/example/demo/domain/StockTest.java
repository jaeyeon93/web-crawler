package com.example.demo.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StockTest {
    private Stock stock;

    @Before
    public void setUp() {
        stock = new Stock("삼성전자", "46,650", "536,450", "2,994,615억");
    }

    @Test
    public void nameTest() {
        assertThat(stock.getName(), is("삼성전자"));
    }

    @Test
    public void makeToJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStock = mapper.writeValueAsString(stock);
        System.out.println(jsonStock);
    }
}

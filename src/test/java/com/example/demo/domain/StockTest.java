package com.example.demo.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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

    @Test
    public void timeTest() throws Exception {
        String format = "yyyyMMdd";;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String startDate = "20180701";
        String endDate = "20180702";
        Date start = sdf.parse(startDate);
        Date end = sdf.parse(endDate);
        long diff = (end.getTime() - start.getTime());
        System.out.println("diff : " + diff);
        System.out.println("diff time : " + (diff / (3600 * 1000)));
    }
}

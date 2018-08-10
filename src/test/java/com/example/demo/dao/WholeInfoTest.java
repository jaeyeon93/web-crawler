package com.example.demo.dao;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class WholeInfoTest {
    private static final Logger logger =  LoggerFactory.getLogger(WholeInfoTest.class);
    private String wholeInfoUrl = "http://finance.daum.net/quote/allpanel.daum?stype=P&type=U";
    private WholeInfo wholeInfo;

    @Before
    public void setUp() {
        wholeInfo = new WholeInfo();
    }

    @Test
    public void contructorAll() {
        wholeInfo.wholeContructor();
    }

    @Test
    public void contructorOne() {
        List<String> list = wholeInfo.contructor();
        System.out.println(list);
    }

    @Test
    public void wholeFinanceTest() {
        wholeInfo.wholeFinace();
    }

    @Test
    public void getBodyTest() {
        wholeInfo = new WholeInfo();
        String result = wholeInfo.getBody();
        logger.info("result : {}", result);
    }

    @Test
    public void getTest() {
        String result = wholeInfo.getTest();
        logger.info("result : {}", result);
    }
}

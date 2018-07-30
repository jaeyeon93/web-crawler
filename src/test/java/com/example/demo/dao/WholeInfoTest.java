package com.example.demo.dao;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WholeInfoTest {
    private static final Logger logger =  LoggerFactory.getLogger(WholeInfoTest.class);
    private String wholeInfoUrl = "http://finance.daum.net/quote/allpanel.daum?stype=P&type=U";
    private WholeInfo wholeInfo;

    @Test
    public void getBodyTest() {
        wholeInfo = new WholeInfo();
        String result = wholeInfo.getBody();
        logger.info("result : {}", result);
    }
}

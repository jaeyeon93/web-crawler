package com.example.demo.dao;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WholeInfoTest {
    private static final Logger logger =  LoggerFactory.getLogger(WholeInfoTest.class);
    private String wholeInfoUrl = "http://finance.daum.net/quote/allpanel.daum?stype=P&type=U";
    private WholeInfo wholeInfo;


    @Before
    public void setUp() throws Exception {
        wholeInfo = new WholeInfo(wholeInfoUrl);
    }

    @Test
    public void 전체정보페이지출력() {
        wholeInfo.getDoc().body().toString();
        String title = wholeInfo.getDoc().title();
        logger.info("title은 : {}", title);
    }

    @Test
    public void bodyInfo() {
        System.out.println(wholeInfo.getDoc().body().getElementById("wrap"));
    }
}

package com.example.demo.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WholeInfo {
    private static final Logger logger =  LoggerFactory.getLogger(WholeInfo.class);
    private String wholeInfoUrl = "http://finance.daum.net/quote/allpanel.daum?stype=P&type=U";
    private Document doc;

    public WholeInfo() {}

    public WholeInfo(String wholeInfoUrl) throws IOException {
        this.wholeInfoUrl = wholeInfoUrl;
        doc = Jsoup.connect(getWholeInfoUrl()).get();
    }

    public String getWholeInfoUrl() {
        return wholeInfoUrl;
    }

    public Document getDoc() {
        return doc;
    }
}

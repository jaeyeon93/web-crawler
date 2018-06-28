package com.example.demo.domain;

import com.example.demo.dao.Research;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class JsoupSearch {
    private String url = "http://finance.daum.net/";
    private Document daum;
    public static final Logger logger = LoggerFactory.getLogger(JsoupSearch.class);

    @Resource(name = "research")
    private Research research;

    public JsoupSearch() throws IOException {
        daum = Jsoup.connect(url).get();
    }

    public void getHtml() throws Exception {
        logger.info(daum.html());
    }

}

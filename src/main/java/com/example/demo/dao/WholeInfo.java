package com.example.demo.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WholeInfo {
    private static final Logger logger =  LoggerFactory.getLogger(WholeInfo.class);
    private String wholeInfoUrl = "http://finance.daum.net/quote/allpanel.daum?stype=P&type=U";
    private WebDriver driver;
    private Document doc;

    public WholeInfo() {}

    public WholeInfo(String wholeInfoUrl) throws IOException {
        this.wholeInfoUrl = wholeInfoUrl;
//        doc = Jsoup.connect(getWholeInfoUrl()).get();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "/Users/jaeyeonkim/Desktop/web-crawler/src/main/java/com/example/demo/chromedriver");
        driver = new ChromeDriver(options);
        String startUrl = "http://finance.daum.net/quote/allpanel.daum?stype=P&type=U";
        driver.get(startUrl);
    }

    public String getBody() {
        return driver.findElement(By.id("wrap")).getText();
    }

    public String getWholeInfoUrl() {
        return wholeInfoUrl;
    }

}

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
    private Document doc;
    private WebDriver driver;


    public WholeInfo() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "/Users/jaeyeonkim/Desktop/web-crawler/src/main/java/com/example/demo/chromedriver");
        driver = new ChromeDriver(options);
        driver.get(getWholeInfoUrl());
    }

    public String getBody() {
        String  body = driver.findElement(By.id("wrap")).getText();
        return body;
    }

    public String getWholeInfoUrl() {
        return wholeInfoUrl;
    }

}

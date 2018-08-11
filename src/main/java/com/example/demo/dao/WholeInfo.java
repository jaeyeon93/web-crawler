package com.example.demo.dao;

import com.example.demo.domain.Stock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WholeInfo {
    private static final Logger logger =  LoggerFactory.getLogger(WholeInfo.class);
    private String wholeInfoUrl = "http://finance.daum.net/quote/allpanel.daum?stype=P&type=U";
    private WebDriver driver;


    public WholeInfo() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "/Users/jaeyeonkim/Desktop/web-crawler/src/main/java/com/example/demo/chromedriver");
        driver = new ChromeDriver(options);
        driver.get(getWholeInfoUrl());
    }

    public List<String> contructor() {
        String body = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div[1]/div[3]/dl[1]")).getText();
        return Arrays.asList(body.split("\n"));
    }

    public List<Stock> wholeContructor() {
        List<Stock> stocks = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            String body = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div[1]/div[3]/dl[" + i + "]")).getText();
            List<String> info = Arrays.asList(body.split("\n"));
            stocks.add(new Stock(info.get(0), info.get(1), info.get(2), info.get(3)));
        }
        return stocks;
    }

    public void wholeFinace() {
        for (int i = 1; i <= 135; i++) {
            String body = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div[2]/div[3]/dl[" + i + "]")).getText();
            System.out.println(Arrays.asList(body.split("\n")));
        }
    }

    public Integer divCount() {
       List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"wrap\"]/div[1]/div[1]/div[3]"));
        return list.size();
    }

    public String getBody() {
        String  body = driver.findElement(By.id("wrap")).getText();
        return body;
    }

    public String getTest() {
        String body = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div[1]/div[3]/dl[4]/dt")).getText();
        return body;
    }

    public String getWholeInfoUrl() {
        return wholeInfoUrl;
    }

}

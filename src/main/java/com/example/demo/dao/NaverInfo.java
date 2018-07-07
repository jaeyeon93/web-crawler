package com.example.demo.dao;

import com.example.demo.domain.NaverStock;
import com.example.demo.domain.Stock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NaverInfo {
    private static final Logger log =  LoggerFactory.getLogger(NaverInfo.class);
    private WebDriver driver;
    private String stockName;
    private List<String> names;
    private NaverStock stock;

    public NaverInfo() {}

    public NaverInfo(String stockName) {
        this.stockName = stockName;
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "/Users/jaeyeonkim/Desktop/web-crawler/src/main/java/com/example/demo/chromedriver");
        driver = new ChromeDriver(options);
        String startUrl = "https://finance.naver.com/";
        driver.get(startUrl);
    }

    public String search() {
        driver.findElement(By.id("stock_items")).sendKeys(getStockName());
        log.info("stockName is : {}", getStockName());
        log.info("page 이동, {}", driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div[2]/form/fieldset/div/button")).click();
        log.info("page 이동, {}", driver.getCurrentUrl());
        //basic Stock
        String price = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/table/tbody/tr[1]/td[2]")).getText();
        String upDown = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/table/tbody/tr[1]/td[3]")).getText();
        String upDownPercnet = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/table/tbody/tr[1]/td[4]")).getText();
        stock = new NaverStock(getStockName(),price, upDown, upDownPercnet);
        log.info("stock info : {}", getStock().toString());
        // detail
        WebElement element = driver.findElement(By.cssSelector("a[title="+getStockName()+"]"));
        String detailUrl = element.getAttribute("href");
        log.info("detailUrl : {}", detailUrl);
        return detailUrl;
    }

    public NaverStock makingNaverStock() {
        driver.get(search());
        getStock().setTotalCost(driver.findElement(By.xpath("//*[@id=\"_market_sum\"]/text()")).getText());
        getStock().setProfit(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/table/tbody/tr[2]/td[4]")).getText());
        log.info("stock info : {}", getStock().toString());
        return stock;
    }

    public String getStockName() {
        return stockName;
    }

    public NaverStock getStock() {
        return stock;
    }
}

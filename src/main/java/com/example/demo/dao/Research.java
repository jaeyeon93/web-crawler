package com.example.demo.dao;

import com.example.demo.domain.JsoupSearch;
import com.example.demo.domain.Stock;
import org.jsoup.Jsoup;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Research {
    public static final Logger logger = LoggerFactory.getLogger(Research.class);
    private WebDriver driver;
    private String stockName;
    private JsoupSearch jsoupSearch;

    public Research() {};

    public Research(String stockName, JsoupSearch jsoupSearch) {
        this.stockName = stockName;
        // 시작 url 및 주식 메인페이지
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/jaeyeonkim/Desktop/web-crawler/src/main/java/com/example/demo/chromedriver");
        String startUrl = "http://finance.daum.net/";
        driver.get(startUrl);
    }

    public void search(String stockName) {
        // serach page
        driver.findElement(By.id("name")).sendKeys(stockName);
        driver.findElement(By.id("daumBtnSearch")).click();
    }

    public void searchDetail() {
        // 디테일 종목 찾기
        WebElement element = driver.findElement(By.cssSelector("a[title="+getStockName()+"]"));
        String detailUrl  = element.getAttribute("href");
        driver.get(detailUrl);
    }

    public Stock make() {
        String price = driver.findElement(By.xpath("//*[@id=\"topWrap\"]/div[1]/ul[2]/li[1]/em")).getText();
        System.out.println("price : " + price);
        String totalCost = driver.findElement(By.xpath("//*[@id=\"stockContent\"]/ul[2]/li[2]/dl[2]/dd")).getText();
        String yearProfit = driver.findElement(By.xpath("//*[@id=\"performanceCorp\"]/table/tbody/tr[5]/td[7]")).getText();
        return new Stock(getStockName(), price, yearProfit, totalCost);
    }

    public String getStockName() {
        return stockName;
    }

    public WebDriver getDriver() {
        logger.info("getDriver method called, driver : {}", getDriver().toString());
        return driver;
    }
}
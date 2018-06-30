package com.example.demo.dao;

import com.example.demo.domain.Stock;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Research {
    public static final Logger logger = LoggerFactory.getLogger(Research.class);
    private WebDriver driver;
    private String stockName;
    private String detailUrl;

    public Research() {}

    public Research(String stockName) {
        this.stockName = stockName;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "/Users/jaeyeonkim/Desktop/web-crawler/src/main/java/com/example/demo/chromedriver");
        driver = new ChromeDriver(options);
        String startUrl = "http://finance.daum.net/";
        driver.get(startUrl);
    }

//    public void search() {
//        driver.findElement(By.id("name")).sendKeys(getStockName());
//        driver.findElement(By.id("daumBtnSearch")).click();
//        // 디테일 종목 찾기
//        WebElement element = driver.findElement(By.cssSelector("a[title="+getStockName()+"]"));
//        String detailUrl  = element.getAttribute("href");
//        driver.get(detailUrl);
//    }
    public String search() {
        driver.findElement(By.id("name")).sendKeys(getStockName());
        driver.findElement(By.id("daumBtnSearch")).click();
        // 디테일 종목 찾기
        WebElement element = driver.findElement(By.cssSelector("a[title="+getStockName()+"]"));
        detailUrl  = element.getAttribute("href");
        return detailUrl;
    }

    public Stock make() {
        driver.get(search());
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
        return driver;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    @Override
    public String toString() {
        return "Research{" +
                "driver=" + driver +
                ", stockName='" + stockName + '\'' +
                '}';
    }
}
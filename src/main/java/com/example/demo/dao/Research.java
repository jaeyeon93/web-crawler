package com.example.demo.dao;

import com.example.demo.domain.Stock;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Research {
    public static final Logger logger = LoggerFactory.getLogger(Research.class);
    private WebDriver driver;
    private String stockName;
    private List<String> names;
    private List<Stock> stocks = new ArrayList<>();

    public Research() {}

    public Research(String stockName) {
        //단일종목
//        this.stockName = stockName;
        // 여러종목
         names = Arrays.asList(stockName.split(","));
         logger.info("Research 객체 전달받은 이름과 리스트 {}, {}", stockName, getNames());
        logger.info("Name 1 : {}", getNames().get(0));
        logger.info("Name 2 : {}", getNames().get(1));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "/Users/jaeyeonkim/Desktop/web-crawler/src/main/java/com/example/demo/chromedriver");
        driver = new ChromeDriver(options);
        String startUrl = "http://finance.daum.net/";
        driver.get(startUrl);
    }


// 단일종목
//    public String search() {
//        driver.findElement(By.id("name")).sendKeys(getStockName());
//        driver.findElement(By.id("daumBtnSearch")).click();
//        // 디테일 종목 찾기
//        WebElement element = driver.findElement(By.cssSelector("a[title="+getStockName()+"]"));
//        String detailUrl  = element.getAttribute("href");
//        return detailUrl;
//    }
//
//    public Stock make() {
//        driver.get(search());
//        String price = driver.findElement(By.xpath("//*[@id=\"topWrap\"]/div[1]/ul[2]/li[1]/em")).getText();
//        System.out.println("price : " + price);
//        String totalCost = driver.findElement(By.xpath("//*[@id=\"stockContent\"]/ul[2]/li[2]/dl[2]/dd")).getText();
//        String yearProfit = driver.findElement(By.xpath("//*[@id=\"performanceCorp\"]/table/tbody/tr[5]/td[7]")).getText();
//        return new Stock(getStockName(), price, yearProfit, totalCost);
//    }


    // 여러개 종목
    public String search(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("daumBtnSearch")).click();
        logger.info("검색 성공 : {}", name);

        //동일종목리스트들
        // 디테일 종목 찾기
        WebElement element = driver.findElement(By.cssSelector("a[title=" + name + ']'));
        logger.info("webElement : {}", element.getAttribute("title"));
        String detailUrl  = element.getAttribute("href");
        logger.info("detailUrl : {}", detailUrl);
        return detailUrl;
    }

    public List<Stock> make() {
        for (String name : getNames()) {
            driver.get(search(name));
            String price = driver.findElement(By.xpath("//*[@id=\"topWrap\"]/div[1]/ul[2]/li[1]/em")).getText();
            System.out.println("price : " + price);
            String totalCost = driver.findElement(By.xpath("//*[@id=\"stockContent\"]/ul[2]/li[2]/dl[2]/dd")).getText();
            String yearProfit = driver.findElement(By.xpath("//*[@id=\"performanceCorp\"]/table/tbody/tr[5]/td[7]")).getText();
            stocks.add(new Stock(name, price, yearProfit, totalCost));
        }
        return stocks;
    }

    public String getStockName() {
        return stockName;
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public String toString() {
        return "Research{" +
                "driver=" + driver +
                ", stockName='" + stockName + '\'' +
                '}';
    }
}
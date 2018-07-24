package com.example.demo.dao;

import com.example.demo.domain.Stock;
import com.example.demo.web.StockController;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class Research {
    public static final Logger logger = LoggerFactory.getLogger(Research.class);
    private WebDriver driver;
    private String stockName;
    private List<String> names;

    public Research() {}

    public Research(String stockName) {
        this.stockName = stockName.toUpperCase();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "/Users/jaeyeonkim/Desktop/web-crawler/src/main/java/com/example/demo/chromedriver");
        driver = new ChromeDriver(options);
        String startUrl = "http://finance.daum.net/";
        driver.get(startUrl);
    }


    public String search() {
        driver.findElement(By.id("name")).sendKeys(getStockName());
        driver.findElement(By.id("daumBtnSearch")).click();
        WebElement element = driver.findElement(By.cssSelector("a[title="+getStockName()+"]"));
        String detailUrl  = element.getAttribute("href");
        return detailUrl;
    }

    public Stock make() {
        driver.get(search());
        String price = driver.findElement(By.xpath("//*[@id=\"topWrap\"]/div[1]/ul[2]/li[1]/em")).getText();
        String salesMoney = driver.findElement(By.xpath("//*[@id=\"performanceCorp\"]/table/tbody/tr[4]/td[9]")).getText();
        String totalCost = driver.findElement(By.xpath("//*[@id=\"stockContent\"]/ul[2]/li[2]/dl[2]/dd")).getText();
        String yearProfit = driver.findElement(By.xpath("//*[@id=\"performanceCorp\"]/table/tbody/tr[5]/td[9]")).getText();
        String changeMoney = driver.findElement(By.xpath("//*[@id=\"topWrap\"]/div[1]/ul[2]/li[2]/span")).getText();
        String changePercent = driver.findElement(By.xpath("//*[@id=\"topWrap\"]/div[1]/ul[2]/li[3]/span")).getText();
        return new Stock(getStockName(), price, salesMoney, yearProfit, totalCost, changeMoney, changePercent, search());
    }

    public String getStockName() {
        return stockName;
    }

    @Override
    public String toString() {
        return "Research{" +
                "driver=" + driver +
                ", stockName='" + stockName + '\'' +
                '}';
    }
}
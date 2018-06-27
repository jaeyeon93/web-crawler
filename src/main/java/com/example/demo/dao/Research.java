package com.example.demo.dao;

import com.example.demo.domain.SamSung;
import com.example.demo.domain.Stock;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Research {
    private WebDriver driver;
    public Research() {
        // 시작
        System.setProperty("webdriver.chrome.driver", "/Users/jaeyeonkim/Desktop/web-crawler/src/main/java/com/example/demo/chromedriver");
        driver = new ChromeDriver();
        String startUrl = "http://finance.daum.net/";
        driver.get(startUrl);
    }

    public void search(String keyword) {
        // serach page
        driver.findElement(By.id("name")).sendKeys(keyword);
        driver.findElement(By.id("daumBtnSearch")).click();
    }

    public void searchDetail(String keyword) {
        // 디테일 종목 찾기
        WebElement element = driver.findElement(By.cssSelector("a[title="+keyword+"]"));
        String detailUrl  = element.getAttribute("href");
        driver.get(detailUrl);
    }

    public Stock make() {
        String price = driver.findElement(By.xpath("//*[@id=\"topWrap\"]/div[1]/ul[2]/li[1]/em")).getText();
        System.out.println("price : " + price);
        String totalCost = driver.findElement(By.xpath("//*[@id=\"stockContent\"]/ul[2]/li[2]/dl[2]/dd")).getText().substring(l);
        String yearProfit = driver.findElement(By.xpath("//*[@id=\"performanceCorp\"]/table/tbody/tr[5]/td[7]")).getText();
        return new SamSung(yearProfit, totalCost,price);
    }

}
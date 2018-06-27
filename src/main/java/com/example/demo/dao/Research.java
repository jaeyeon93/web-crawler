package com.example.demo.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

    public void searchDetail(String keyworld) {
//        System.out.println(driver.getPageSource());
        List<WebElement> list = driver.findElements(By.tagName("a"));
        for (WebElement w : list)
            System.out.println(w.getAttribute("href"));

    }
}

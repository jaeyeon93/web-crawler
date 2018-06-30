package com.example.demo.domain;

import com.example.demo.dao.Research;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.IOException;

public class JsoupSearch {
    public static final Logger logger = LoggerFactory.getLogger(JsoupSearch.class);
    private Document doc;
    private Research research;

    public JsoupSearch(Research research) throws IOException {
        this.research = research;
        doc = Jsoup.connect(research.search()).get();
        logger.info("JsoupSearch객체 생성");
    }

    public void make() throws Exception {
        String price = doc.select("#topWrap > div.topInfo > ul.list_stockrate > li:nth-child(1) > em").text();
        String change = doc.select("#topWrap > div.topInfo > ul.list_stockrate > li:nth-child(2) > span").text();
        String changePercent = doc.select("#topWrap > div.topInfo > ul.list_stockrate > li:nth-child(3) > span").text();
        String totalCost = doc.select("#stockContent > ul.list_descstock > li:nth-child(2) > dl.second > dd").text();
        String yearProfit = doc.select("#performanceCorp > table > tbody > tr:nth-child(5) > td:nth-child(9)").text();
        logger.info("price : {}", price);
        logger.info("change : {}", change);
        logger.info("changePercent : {}", changePercent);
        logger.info("totalCost : {}", totalCost);
        logger.info("yearProfit : {}", yearProfit);
    }

    public Document getDoc() {
        return doc;
    }

    public Research getResearch() {
        return research;
    }

    //    public Stock make() {
//        String price = driver.findElement(By.xpath("//*[@id=\"topWrap\"]/div[1]/ul[2]/li[1]/em")).getText();
//        System.out.println("price : " + price);
//        String totalCost = driver.findElement(By.xpath("//*[@id=\"stockContent\"]/ul[2]/li[2]/dl[2]/dd")).getText();
//        String yearProfit = driver.findElement(By.xpath("//*[@id=\"performanceCorp\"]/table/tbody/tr[5]/td[7]")).getText();
//        return new Stock(getStockName(), price, yearProfit, totalCost);
//    }

}

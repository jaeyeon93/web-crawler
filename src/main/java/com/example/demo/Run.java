package com.example.demo;

import com.example.demo.dao.Research;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
//        Research samsung = Jsoup.connect("http://finance.daum.net/item/main.daum?code=005930");
//
//        Research.Response response = Jsoup.connect("http://finance.daum.net/item/main.daum?code=005930")
//                .method(Research.Method.GET)
//                .execute();
//
//        Document document = response.parse();
//        Element element = document.select("em.curPrice.up").first();
//        System.out.println(element);
//        System.out.println(element.text());
        String searchWord = "삼성전자";
        Research research = new Research();
        research.search(searchWord);
        research.searchDetail(searchWord);
        research.make();
    }
}

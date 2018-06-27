package com.example.demo;

import com.example.demo.dao.Research;
import com.example.demo.domain.Stock;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
        String searchWord = "삼성전자";
        Research research = new Research();
        research.search(searchWord);
        research.searchDetail(searchWord);
        Stock samsung = research.make();
        System.out.println(samsung.toString());
    }
}

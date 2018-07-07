package com.example.demo.domain;

import javax.persistence.Entity;

public class NaverStock {
    private String stockName;
    private String price;
    private String upDown;
    private String upDownPercnet;
    private String profit;
    private String totalCost;

    public NaverStock(String stockName, String price, String upDown, String upDownPercnet) {
        this.stockName = stockName;
        this.price = price;
        this.upDown = upDown;
        this.upDownPercnet = upDownPercnet;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getStockName() {
        return stockName;
    }

    public String getPrice() {
        return price;
    }

    public String getUpDown() {
        return upDown;
    }

    public String getUpDownPercnet() {
        return upDownPercnet;
    }

    public String getProfit() {
        return profit;
    }

    public String getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "NaverStock{" +
                "stockName='" + stockName + '\'' +
                ", price='" + price + '\'' +
                ", upDown='" + upDown + '\'' +
                ", upDownPercnet='" + upDownPercnet + '\'' +
                ", profit='" + profit + '\'' +
                ", totalCost='" + totalCost + '\'' +
                '}';
    }
}

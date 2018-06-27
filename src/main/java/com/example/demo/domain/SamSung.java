package com.example.demo.domain;

public class SamSung implements Stock {
    private String profit;
    private String totalCost;
    private String price;

    public SamSung() {}

    public SamSung(String profit, String totalCost, String price) {
        this.profit = profit;
        this.totalCost = totalCost;
        this.price = price;
    }

    @Override
    public String getProfit() {
        return profit;
    }

    @Override
    public String getPrice() {
        return price;
    }

    public String getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "SamSung{" +
                "profit=" + profit +
                ", totalCost=" + totalCost +
                ", price=" + price +
                '}';
    }
}

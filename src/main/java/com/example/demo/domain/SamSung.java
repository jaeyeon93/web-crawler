package com.example.demo.domain;

public class SamSung implements Stock {
    private int profit;
    private int totalCost;
    private int price;

    public SamSung() {}

    @Override
    public int getProfit() {
        return profit;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public int getTotalCost() {
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

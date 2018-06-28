package com.example.demo.domain;

public class Stock {
    private String name;
    private String price;
    private String profit;
    private String totalCost;

    public Stock(String name, String price, String profit, String totalCost) {
        this.name = name;
        this.price = price;
        this.profit = profit;
        this.totalCost = totalCost;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getProfit() {
        return profit;
    }

    public String getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", profit='" + profit + '\'' +
                ", totalCost='" + totalCost + '\'' +
                '}';
    }
}

package com.example.demo.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Stock extends AbstractEntity {

    @Column(unique = true)
    private String name;

    @Column
    private String price;

    @Column
    private String profit;

    @Column
    private String totalCost;

    public Stock() {}

    public Stock(String name, String price, String profit, String totalCost) {
        super();
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

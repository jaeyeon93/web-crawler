package com.example.demo.domain;

import com.example.demo.support.domain.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Stock extends AbstractEntity {
    public static final Logger logger = LoggerFactory.getLogger(Stock.class);

    @Column(unique = true)
    @JsonProperty
    private String name;

    @Column
    @JsonProperty
    private String price;

    @Column
    @JsonProperty
    private String profit;

    @Column
    @JsonProperty
    private String totalCost;

    public Stock() {}

    public Stock(String name, String price, String profit, String totalCost) {
        super();
        this.name = name;
        this.price = price;
        this.profit = profit;
        this.totalCost = totalCost;
        logger.info("stock 생성 : {}", toString());
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

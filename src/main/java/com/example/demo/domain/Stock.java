package com.example.demo.domain;

import com.example.demo.support.domain.AbstractEntity;
import com.example.demo.support.domain.UrlGeneratable;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Stock extends AbstractEntity implements UrlGeneratable {
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

    public Stock(String name) {
        this.name = name;
    }

    public Stock(String name, String price, String profit, String totalCost) {
        this(0L, name, price, profit, totalCost);
        logger.info("id = 0으로 설정한 stock객체생성");
    }

//    public Stock(String name, String price, String profit, String totalCost) {
//        this.name = name;
//        this.price = price;
//        this.profit = profit;
//        this.totalCost = totalCost;
//        logger.info("stock 생성 : {}", toString());
//    }

    public Stock(long id, String name, String price, String profit, String totalCost) {
        super(id);
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
    public String generateUrl() {
        return String.format("/stock/%d", getId());
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", id='" + getId() + '\'' +
                ", price='" + price + '\'' +
                ", profit='" + profit + '\'' +
                ", totalCost='" + totalCost + '\'' +
                '}';
    }
}

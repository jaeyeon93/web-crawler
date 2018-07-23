package com.example.demo.domain;

//import com.example.demo.support.domain.AbstractEntity;
import com.example.demo.support.domain.AbstractEntity;
import com.example.demo.support.domain.UrlGeneratable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Entity
public class Stock extends AbstractEntity implements UrlGeneratable {
    public static final Logger logger = LoggerFactory.getLogger(Stock.class);

    @Column
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

    @Column
    @JsonProperty
    private String changeMoney;

    @Column
    @JsonProperty
    private String changePerent;

    @Column
    @JsonProperty
    private String detailUrl;

    @Column
    @JsonProperty
    private String path;

    public Stock() {}

    public Stock(String name) {
        this.name = name;
    }

    public Stock(String name, String price, String profit, String totalCost) {
        this.name = name.toUpperCase();
        this.price = price;
        this.profit = profit;
        this.totalCost = totalCost;
    }

    public Stock(String name, String price, String profit, String totalCost,String changeMoney, String changePerent, String detailUrl) {
        this.name = name.toUpperCase();
        this.price = price;
        this.profit = profit;
        this.totalCost = totalCost;
        this.changeMoney = changeMoney;
        this.changePerent = changePerent;
        this.detailUrl = detailUrl;
        logger.info("stock 생성 : {}", toString());
    }

    public Stock(long id, String name, String price, String profit, String totalCost) {
        super(id);
        this.name = name.toUpperCase();
        this.price = price;
        this.profit = profit;
        this.totalCost = totalCost;
        logger.info("stock 생성2 : {}", toString());
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String generateUrl() {
        return String.format("/stock/%d", getId());
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", profit='" + profit + '\'' +
                ", totalCost='" + totalCost + '\'' +
                ", changeMoney='" + changeMoney + '\'' +
                ", changePerent='" + changePerent + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                '}';
    }
}

package com.example.demo.domain;

//import com.example.demo.support.domain.AbstractEntity;
import com.example.demo.support.domain.UrlGeneratable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Entity
public class Stock extends ResourceSupport implements UrlGeneratable {
    public static final Logger logger = LoggerFactory.getLogger(Stock.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

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

    public Stock() {}

    public Stock(String name) {
        this.name = name;
    }

    public Stock(String name, String price, String profit, String totalCost) {
        this.name = name;
        this.price = price;
        this.profit = profit;
        this.totalCost = totalCost;
        // 수동테스트
        logger.info(",stock 생성1 : {}", toString());
    }

    public Stock(long id, String name, String price, String profit, String totalCost) {
        this.id = id;
        this.name = name;
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

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String generateUrl() {
        return String.format("/stock/%d", getId());
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", profit='" + profit + '\'' +
                ", totalCost='" + totalCost + '\'' +
                '}';
    }
}

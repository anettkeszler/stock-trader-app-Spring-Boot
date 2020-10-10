package com.codecool.stocktraderspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockTraderSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockTraderSpringBootApplication.class, args);
    }

    // @WebController

    // TASK 1: create a WebController, that defines the path to interact with => GET /buy
    // responed with 'hello world'

    // TASK 2: the path parameterized => GET /buy/{name}/{price}
    // localhost:8080/buy/aapl/100
}

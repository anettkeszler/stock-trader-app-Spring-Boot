package com.codecool.stocktraderspringboot;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Trader {
    private Logger logger;
    private StockAPIService stockService;

    @Autowired
    public Trader(Logger logger, StockAPIService stockAPIService) {
        this.logger = logger;
        this.stockService = stockAPIService;
    }

    /** Checks the price of a stock, and buys it if the price is not greater than the bid amount.
     * 	@return whether any stock was bought */
    public boolean buy(String symbol, double bid) throws IOException {
        double price = stockService.getPrice(symbol);

        boolean result;
        if (price <= bid) {
            result = true;
            stockService.buy(symbol);
            logger.info("Purchased " + symbol + " stock at $" + bid + ", since its higher that the current price ($" + price + ")");
        }
        else {
            logger.info("Bid for " + symbol + " was $" + bid + " but the stock price is $" + price + ", no purchase was made.");
            result = false;
        }
        return result;
    }
}

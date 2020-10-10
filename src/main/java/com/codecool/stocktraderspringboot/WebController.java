package com.codecool.stocktraderspringboot;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @Autowired
    private Logger logger;

    @Autowired
    private Trader trader;

    @GetMapping(value = "/buy/{name}/{price}")
    public @ResponseBody String getResponse(@PathVariable String name, @PathVariable int price) {
        String response = "";
        try {
            boolean purchased = trader.buy(name, price);
            if (purchased) {
                response = "Purchased stock!";
                logger.info("Purchased stock!");
            }
            else {
                response = "Couldn't buy the stock at that price.";
                logger.info("Couldn't buy the stock at that price.");
            }
        } catch (Exception e) {
            response = "There was an error while attempting to buy the stock.";
            logger.error("There was an error while attempting to buy the stock: " + e.getMessage());
        }
        return response;
    }

}

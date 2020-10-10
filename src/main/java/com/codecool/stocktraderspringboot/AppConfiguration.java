package com.codecool.stocktraderspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {


    @Bean
    public Logger createLogger() {
        return LoggerFactory.getLogger("My App Logger");
    }

    @Bean
    public RemoteURLReader createRemoteURLReader() {
        return new RemoteURLReader();
    }

    @Bean
    public StockAPIService createStockAPIService(RemoteURLReader remoteURLReader) {
        return new StockAPIService(remoteURLReader);
    }

    @Bean
    public Trader createTrader(Logger logger, StockAPIService stockAPIService) {
        return new Trader(logger, stockAPIService);
    }

}

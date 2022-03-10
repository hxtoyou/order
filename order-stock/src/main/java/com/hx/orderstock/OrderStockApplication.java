package com.hx.orderstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderStockApplication.class, args);
    }

}

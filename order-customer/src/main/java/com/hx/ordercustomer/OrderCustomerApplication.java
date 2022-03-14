package com.hx.ordercustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderCustomerApplication.class, args);
    }

}

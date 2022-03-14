package com.hx.ordercustomer.service;

import org.springframework.stereotype.Component;

@Component
public class WebFirstFeignFallback implements IorderService {


    @Override
    public String getServiceInfo() {
        return "短融";
    }
}
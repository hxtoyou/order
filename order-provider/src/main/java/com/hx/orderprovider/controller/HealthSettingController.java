package com.hx.orderprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthSettingController {



    @Autowired
    private KafkaTemplate kafkaTemplate;
    @RequestMapping("health")
    public String up() {


        return "32323232";
    }

}
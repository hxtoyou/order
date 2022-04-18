package com.hx.orderprovider.controller;

import com.example.ordercommon.entity.OrderConstants;
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

        String var = OrderConstants.TOPIC_TEST;
        return "32323232"+var;
    }

}
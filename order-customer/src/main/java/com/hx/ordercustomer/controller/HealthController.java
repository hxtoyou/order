package com.hx.ordercustomer.controller;

import com.example.ordercommon.entity.OrderConstants;
import com.hx.ordercustomer.service.IorderService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

@Autowired
private IorderService iorderService;

@Autowired
private KafkaTemplate kafkaTemplate;

    @RequestMapping("health2")
    public String up() {
        kafkaTemplate.send(OrderConstants.TOPIC_TEST,"val1");
        String rs = iorderService.getServiceInfo();
        return rs;
    }

    @KafkaListener(topics = {"test2"})
    public void handleMessage(ConsumerRecord record) {
        System.out.println(record.value());
    }


}
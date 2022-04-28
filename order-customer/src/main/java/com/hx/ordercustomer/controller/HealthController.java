package com.hx.ordercustomer.controller;

import com.example.ordercommon.entity.OrderConstants;
import com.hx.ordercustomer.service.IorderService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

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

    @RequestMapping("message")
    public String message() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.5:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);
        for (int i=0;i<5;i++){
            producer.send(new ProducerRecord<>("qy","hello"+i));
        }
        return "chengggong";
    }

    @KafkaListener(topics = {"test2"})
    public void handleMessage(ConsumerRecord record) {
        System.out.println(record.value());
    }


}
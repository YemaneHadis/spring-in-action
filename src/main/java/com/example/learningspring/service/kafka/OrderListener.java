package com.example.learningspring.service.kafka;

import com.example.learningspring.model.TacoOrder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {



    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(TacoOrder order){
        System.out.println(order.toString());
    }

}

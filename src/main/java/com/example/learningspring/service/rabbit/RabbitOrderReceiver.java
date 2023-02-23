package com.example.learningspring.service.rabbit;

import com.example.learningspring.model.TacoOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.amqp.core.Message;

@Component
public class RabbitOrderReceiver {
    private RabbitTemplate rabbitTemplate;
    private MessageConverter converter;

    @Autowired
    public  RabbitOrderReceiver(RabbitTemplate rabbit){
        this.rabbitTemplate = rabbit;
        this.converter = rabbit.getMessageConverter();

    }
    @RabbitListener(queues = "tacocloud.order.queue")
    public TacoOrder receiveOrder(){
        Message message = rabbitTemplate.receive("tacocloud.order");
        System.out.println("This is AfroWeb");
        return message !=null
                ?(TacoOrder) converter.fromMessage(message)
                : null;

    }
}

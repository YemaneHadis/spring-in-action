package com.example.learningspring.service.rabbit;

import com.example.learningspring.model.TacoOrder;
import com.example.learningspring.service.OrderMessagingService;

import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Message;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService {
    private RabbitTemplate rabbit;

    @Autowired
    public RabbitOrderMessagingService(RabbitTemplate rabbit){
        this.rabbit = rabbit;
    }


    @Override
    public void sendOrder(TacoOrder order) {
        MessageConverter converter  =  rabbit.getMessageConverter();
        MessageProperties properties = new MessageProperties();
        Message message  = converter.toMessage(order,properties);
        rabbit.send("tacocloud.order",message);
    }
}

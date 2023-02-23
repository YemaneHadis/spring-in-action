package com.example.learningspring.service.jms;



import com.example.learningspring.model.TacoOrder;
import jakarta.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
//@Profile("jms-listener")
public class JmsOrderReceiver implements OrderReceiver {
    private JmsTemplate jms;
    private final MessageConverter converter;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter) {
        this.jms = jms;
        this.converter = converter;
    }
    @Override
    @JmsListener(destination = "tacocloud.order.queue")
    public TacoOrder receiveOrder() throws JMSException {
        System.out.println((TacoOrder) jms.receiveAndConvert("tacocloud.order.queue"));
        System.out.println();
//        Message message = jms.receive("tacocloud.order.queue");
//        return (TacoOrder) converter.fromMessage(message);
        return (TacoOrder) jms.receiveAndConvert("tacocloud.order.queue");
    }
}

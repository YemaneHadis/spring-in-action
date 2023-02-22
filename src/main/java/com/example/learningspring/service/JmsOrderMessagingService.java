package com.example.learningspring.service;


import com.example.learningspring.model.TacoOrder;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderMessagingService  implements OrderMessagingService  {

    private JmsTemplate jms;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms){
        this.jms = jms;

    }


    @Override
    public void sendOrder(TacoOrder order){
        jms.send(new MessageCreator() {
                     @Override
                     public Message createMessage(Session session)
                             throws JMSException {
                         return session.createObjectMessage(order);
                     }
                 }
        );
    }


}

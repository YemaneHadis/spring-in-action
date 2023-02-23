package com.example.learningspring.service.jms;


import com.example.learningspring.model.TacoOrder;
import com.example.learningspring.service.OrderMessagingService;
import jakarta.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderMessagingService  implements OrderMessagingService {

    private JmsTemplate jms;

    private Destination orderQueue;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms, Destination orderQueue){
        this.jms = jms;
        this.orderQueue = orderQueue;

    }


    @Override
    public void sendOrder(TacoOrder order){
//        jms.send(new MessageCreator() {
//            orderQueue,
//                     @Override
//                     public Message createMessage(Session session)
//                             throws JMSException {
//                         return session.createObjectMessage(order);
//                     }
//                 }
//        );
//        jms.send(
//                orderQueue,
//                session -> session.createObjectMessage(order)
//                );
        jms.convertAndSend("tacocloud.order.queue",order);
    }


}

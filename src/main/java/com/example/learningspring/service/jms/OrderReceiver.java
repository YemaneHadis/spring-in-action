package com.example.learningspring.service.jms;


import com.example.learningspring.model.TacoOrder;
import jakarta.jms.JMSException;

public interface OrderReceiver {
    public TacoOrder receiveOrder() throws JMSException;
}

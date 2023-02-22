package com.example.learningspring.service;


import com.example.learningspring.model.TacoOrder;

public interface OrderMessagingService {
     public void sendOrder(TacoOrder order);


}

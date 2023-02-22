package com.example.learningspring.controller;

import com.example.learningspring.model.TacoOrder;
import com.example.learningspring.repository.OrderRepository;
import com.example.learningspring.service.OrderMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders", produces = "application/json")
public class OrderApiController {
    private OrderRepository orderRepository;

    private OrderMessagingService orderMessagingService;

    @Autowired
    public OrderApiController(OrderRepository orderRepository, OrderMessagingService orderMessagingService) {
        this.orderRepository = orderRepository;
        this.orderMessagingService = orderMessagingService;
    }



    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void postOrder(@RequestBody TacoOrder order){
        orderMessagingService.sendOrder(order);
//        return orderRepository.save(order);
    }


}

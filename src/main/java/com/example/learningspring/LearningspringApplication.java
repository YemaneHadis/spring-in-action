package com.example.learningspring;

import com.example.learningspring.model.TacoOrder;
import jakarta.jms.Destination;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.HashMap;
import java.util.Map;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@SpringBootApplication
public class LearningspringApplication {

	@Bean
	public Destination orderQueue() {
		return new ActiveMQQueue("tacocloud.order.queue");
	}

	@Bean
	public MappingJackson2MessageConverter messageConverter(){
		MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
		messageConverter.setTypeIdPropertyName("_typeId");
		Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
		typeIdMappings.put("order", TacoOrder.class);
		messageConverter.setTypeIdMappings(typeIdMappings);
		return messageConverter;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearningspringApplication.class, args);
	}

}

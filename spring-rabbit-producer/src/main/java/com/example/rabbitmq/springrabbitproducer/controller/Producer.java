package com.example.rabbitmq.springrabbitproducer.controller;

import com.example.rabbitmq.springrabbitproducer.model.Message;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class Producer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    HeadersExchange headersExchange;
  /*  @Autowired
    DirectExchange directExchange;*/
 /* @Autowired
  FanoutExchange fanoutExchange;
*/
    /*@Autowired
    TopicExchange topicExchange;*/

 /*  @PostMapping("/posting")
    public String send(@RequestBody Message message) {
        System.out.println("hello");
        rabbitTemplate.convertAndSend(directExchange.getName(),"routing.A",message);
        return "message sent successfully";
    }*/

    /*@PostMapping("/posting/{message}")
 public String send(@PathVariable(value ="message") String message) {
     System.out.println("hello");
    // rabbitTemplate.convertAndSend(topicExchange.getName(), "routing.A", message);
     MessageProperties messageProperties=new MessageProperties();
     messageProperties.setHeader("food",message);
     MessageConverter messageConverter=new SimpleMessageConverter();
     org.springframework.amqp.core.Message message1=messageConverter.toMessage(message,messageProperties);
     rabbitTemplate.send(headersExchange.getName(),"",message1);
     return "message sent successfully";
 }*/

    @PostMapping("/posting/{message}")    // default exchange
    public String send(@PathVariable(value ="message") String message) {
        System.out.println("hello");
        rabbitTemplate.convertAndSend("queueA", message);
        return "message sent successfully";
    }


}

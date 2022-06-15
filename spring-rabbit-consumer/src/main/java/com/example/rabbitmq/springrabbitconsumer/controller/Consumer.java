package com.example.rabbitmq.springrabbitconsumer.controller;

import com.example.rabbitmq.springrabbitconsumer.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {
   /* @RabbitListener(queues="queueA")
    private void receive(Message message){
        System.out.println("-------------------------???????");
        log.info("Message received from queue A->{}",message);
    }
    @RabbitListener(queues="queueB")
    private void receiveFromB(Message message){
        log.info("Message received from queue B->{}",message);
    }
    @RabbitListener(queues="queueAll")
    private void receiveFromAll(Message message){
        log.info("Message received from queue All->{}",message);
    }*/
    @RabbitListener(queues="queueA")
    private void receive(String message){
        System.out.println("-------------------------???????");
        log.info("Message received from queue A->{}",message);
    }
    @RabbitListener(queues="queueB")
    private void receiveFromB(String message){
        log.info("Message received from queue B->{}",message);
    }
    @RabbitListener(queues="queueAll")
    private void receiveFromAll(String message){
        log.info("Message received from queue All->{}",message);
    }
}

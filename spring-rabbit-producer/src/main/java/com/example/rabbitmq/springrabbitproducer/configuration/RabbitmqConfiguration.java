package com.example.rabbitmq.springrabbitproducer.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class RabbitmqConfiguration {

    @Bean
    Queue queueA()
    {
        return new Queue("queueA",false);
    }
    @Bean
    Queue queueB()
    {
        return new Queue("queueB",false);
    }
    @Bean
    Queue queueAll()
    {
        return new Queue("queueAll",false);
    }
   /* @Bean
    TopicExchange topicExchange(){
        return new TopicExchange("exchange.topic");
    }*/
   @Bean
   HeadersExchange headerExchange(){
       return new HeadersExchange("exchange.header");
   }
    /*@Bean
    DirectExchange excahnge(){
        return new DirectExchange("exchange.direct");
    }*/

   /* @Bean
    FanoutExchange fnexcahnge(){
        return new FanoutExchange("exchange.fanout");
    }*/
   /* @Bean
    Binding bindingA(Queue queueA,DirectExchange exchange){
        return BindingBuilder.bind(queueA).to(exchange).with("routing.A");
    }
    @Bean
    Binding bindingB(Queue queueB,DirectExchange exchange){
        return BindingBuilder.bind(queueB).to(exchange).with("routing.B");
    }*/
  /*  @Bean
    Binding bindingA(Queue queueA,FanoutExchange fnexchange){
        return BindingBuilder.bind(queueA).to(fnexchange);
    }
    @Bean
    Binding bindingB(Queue queueB,FanoutExchange fnexchange){
        return BindingBuilder.bind(queueB).to(fnexchange);
    }*/
  /* @Bean
   Binding bindingA(Queue queueA,TopicExchange exchange){
       return BindingBuilder.bind(queueA).to(exchange).with("routing.A");
   }
    @Bean
    Binding bindingB(Queue queueB,TopicExchange exchange){
        return BindingBuilder.bind(queueB).to(exchange).with("routing.B");
    }*/
   @Bean
   Binding bindingA(Queue queueA,HeadersExchange exchange){
       return BindingBuilder.bind(queueA).to(exchange).where("food").matches("pizza");
   }
    @Bean
    Binding bindingB(Queue queueB,HeadersExchange exchange){
        return BindingBuilder.bind(queueB).to(exchange).where("food").matches("dosa");
    }
    @Bean
    Binding bindingAll(Queue queueAll,HeadersExchange exchange){
        return BindingBuilder.bind(queueAll).to(exchange).where("food").matches("gujarati");
   }
   /* @Bean
    Binding bindingAll(Queue queueAll,TopicExchange exchange){
        return BindingBuilder.bind(queueAll).to(exchange).with("routing.*");
    }*/
    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory factory)
    {
        RabbitTemplate rabbitTemplate= new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;

    }

}

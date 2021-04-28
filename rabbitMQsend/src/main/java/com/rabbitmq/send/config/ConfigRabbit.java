/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabbitmq.send.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jhonfre
 */
@Configuration
public class ConfigRabbit {

    @Bean
    Queue marketingQueueTopic() {
        return new Queue("marketingQueueTopic");
    }

    @Bean
    Queue financeQueueTopic() {
        return new Queue("financeQueueTopic");
    }

    @Bean
    Queue adminQueueTopic() {
        return new Queue("adminQueueTopic");
    }


    @Bean
    DirectExchange topicExchange() {
        return new DirectExchange("topic-exchange");
    }

    @Bean
    Binding marketingBindingTopic(Queue marketingQueueTopic, DirectExchange topicExchange) {
        return BindingBuilder.bind(marketingQueueTopic).to(topicExchange).with("queue_marketing");
    }

    @Bean
    Binding financeBindingTopic(Queue financeQueueTopic, DirectExchange topicExchange) {
        return BindingBuilder.bind(financeQueueTopic).to(topicExchange).with("queue_finance");
    }

    @Bean
    Binding adminBindingTopic(Queue adminQueueTopic, DirectExchange topicExchange) {
        return BindingBuilder.bind(adminQueueTopic).to(topicExchange).with("queue_admin");
    }


    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabbitmq.receive.recive;

import com.rabbitmq.receive.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author jhonfre
 */
@Component
public class RabbitMqReceiver {

    public static final String QUEUEMARKETING = "marketingQueueTopic";
    public static final String QUEUEFINANCE = "financeQueueTopic";
    public static final String QUEUEADMIN = "adminQueueTopic";


    @RabbitListener(queues = QUEUEMARKETING)
    public void receivedMessageMarketing(User user) {
        System.out.println("MENSAJE LLEGANDOOOO DE COLA DE MARKETING");
        System.out.println(user.toString());
    }

    @RabbitListener(queues = QUEUEFINANCE)
    public void receivedMessageFinance(User user) {
        System.out.println("MENSAJE LLEGANDOOOO DE COLA DE FINANCIERA");
        System.out.println(user.toString());
    }

    @RabbitListener(queues = QUEUEADMIN)
    public void receivedMessageAdmin(User user) {
        System.out.println("MENSAJE LLEGANDOOOO DE COLA DE ADMINISTRACION");
        System.out.println(user.toString());
    }
}

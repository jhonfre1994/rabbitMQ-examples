package com.rabbitmq.send.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.rabbitmq.send.impl.RabbitMqSender;
import com.rabbitmq.send.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhonfre
 */
@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerController {

    private RabbitMqSender rabbitMqSender;

    @Autowired
    public ProducerController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @PostMapping(value = "user")
    public String publishUserDetails(@RequestParam("exchangeName") String exchangeName,
            @RequestParam("routingKey") String routingKey,
            @RequestBody User user) {
        rabbitMqSender.send(exchangeName, routingKey, user);
        return "Mensaje enviado correntamente";
    }

}

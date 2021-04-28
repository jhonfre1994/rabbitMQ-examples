package com.rabbitmq.receive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ReceiveApplication {


    public static void main(String[] args) throws IOException, IOException, TimeoutException {
        SpringApplication.run(ReceiveApplication.class, args);


    }
}

package com.adekah.listener;

import com.adekah.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    @RabbitListener(queues = "spring-rabbitmq-example-queue")
    public void handleMessage(Notification notification) {
        System.out.println("Message Received");
        System.out.println(notification.toString());
    }
}

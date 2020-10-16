package com.adekah.producer;

import com.adekah.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Value("${spring.rabbit.queue.name}")
    private String routingName;

    @Value("${spring.rabbit.exchange.name}")
    private String exchangeName;



//    @PostConstruct
//    public void init() throws InterruptedException {
//        Notification notification = new Notification();
//        notification.setId(UUID.randomUUID().toString());
//        notification.setCreatedAt(new Date());
//        notification.setMessage("RabbitMQ Kuyruk Denemesi....");
//        notification.setSeen(Boolean.FALSE);
//        sendToQueue(notification);
//    }

    @Scheduled(fixedRate = 5000)
    public void Produce(){
        Notification notification = new Notification();
        notification.setId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("RabbitMQ Kuyruk Denemesi....");
        notification.setSeen(Boolean.FALSE);
        sendToQueue(notification);
    }


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent Id:" + notification.getId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }

}

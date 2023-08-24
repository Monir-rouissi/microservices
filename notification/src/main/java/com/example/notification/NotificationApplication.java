package com.example.notification;

import com.example.notification.event.OrderPlaceEvent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class NotificationApplication {
    Logger logger = Logger.getLogger(String.valueOf(NotificationApplication.class));
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlaceEvent orderPlaceEvent)
    {
        logger.log(Level.INFO,"processing notification");
    }

}
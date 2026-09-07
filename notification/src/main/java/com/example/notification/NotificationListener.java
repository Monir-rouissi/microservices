package com.example.notification;

import com.example.notification.event.OrderPlaceEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.notifications.enabled", havingValue = "true")
class NotificationListener {
    private final Logger logger = Logger.getLogger(NotificationListener.class.getName());

    @KafkaListener(topics = "notificationTopic")
    void handleNotification(OrderPlaceEvent orderPlaceEvent) {
        logger.log(Level.INFO, "processing notification");
    }
}

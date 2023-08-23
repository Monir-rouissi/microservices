package com.order.order.services;

import com.order.order.dto.OrderLineDto;
import com.order.order.dto.OrderRequest;
import com.order.order.model.InventoryResponse;
import com.order.order.model.Order;
import com.order.order.model.OrderLine;
import com.order.order.repos.OrderRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private static final String inventoryUri = "http://localhost:8080/api/inventory";
    private OrderRepo orderController;
    private WebClient webClient;
    private OrderRepo orderRepository;
    private final KafkaTemplate<String,String> kafkaTemplate;

    public OrderService(OrderRepo orderController, WebClient webClient, OrderRepo orderRepository, KafkaTemplate kafkaTemplate) {
        this.orderController = orderController;
        this.webClient = webClient;
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public InventoryResponse[] isSkuAvailable(List<String> skuCodes) {
        //call inventory serivce using webClient
        return webClient.get()
                .uri(inventoryUri ,uriBuilder->uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();


    }

    public ResponseEntity<Order> placeOrder(OrderRequest orderRequest) {
        List<OrderLine> orderLineList =
                orderRequest.orderLines().stream().map(this::mapToModel).toList();
        //create order
        var order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLines(orderLineList);

        var skuCodes = orderLineList.stream().map(OrderLine::getSkuCode).toList();
        //save order if skuAvailable
        InventoryResponse[] skuAvailable = isSkuAvailable(skuCodes);
        if (skuAvailable.length >0 && Arrays.stream(skuAvailable).allMatch(InventoryResponse::isInStock)) {
            kafkaTemplate.send("notificationTopic",order.getOrderNumber());
            return ResponseEntity.status(HttpStatus.CREATED).body(orderRepository.save(order));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(order);
    }

    private OrderLine mapToModel(OrderLineDto orderLineDto) {
    return new OrderLine(orderLineDto.id(),  orderLineDto.skuCode(), orderLineDto.price(), orderLineDto.quantity());
    }
}

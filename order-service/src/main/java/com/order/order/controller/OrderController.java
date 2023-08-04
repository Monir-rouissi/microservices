package com.order.order.controller;

import com.order.order.dto.OrderRequest;
import com.order.order.model.Order;
import com.order.order.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/order")
@RestController
public class OrderController
{
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest order){
      return  service.placeOrder(order);
    }
    /*@GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean placeOrder(@PathVariable(name = "sku-code") String skuCode)
    {
        return service.isSkuAvailable(skuCode);
    }*/


}

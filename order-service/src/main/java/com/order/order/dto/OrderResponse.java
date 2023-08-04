
package com.order.order.dto;

import com.order.order.model.OrderLine;
import jakarta.persistence.*;

import java.util.List;


public class OrderResponse {
    private List<OrderLineDto> orderLines;
}

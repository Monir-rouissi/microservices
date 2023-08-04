package com.order.order.dto;

import com.order.order.model.OrderLine;
import jakarta.persistence.*;

import java.util.List;


public record OrderRequest(List<OrderLineDto> orderLines) {


}

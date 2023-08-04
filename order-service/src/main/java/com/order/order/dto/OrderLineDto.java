package com.order.order.dto;

import java.math.BigDecimal;

public record OrderLineDto( Long id, String skuCode, BigDecimal price, Integer quantity) {

}

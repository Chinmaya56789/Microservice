package com.microservices.Order_Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class OrderLineItemDTO {

    private String skuCode;
    private BigDecimal price;
    private Long qunatity;
}

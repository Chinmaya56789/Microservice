package com.microservices.Order_Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
public class StockeCheckDTO {
    private String skuCode;
    protected BigDecimal requestedQuantity;
}

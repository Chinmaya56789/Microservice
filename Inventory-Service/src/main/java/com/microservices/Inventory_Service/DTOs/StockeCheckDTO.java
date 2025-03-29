package com.microservices.Inventory_Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
public class StockeCheckDTO {
    private String skuCode;
    protected BigDecimal requestedQuantity;
}

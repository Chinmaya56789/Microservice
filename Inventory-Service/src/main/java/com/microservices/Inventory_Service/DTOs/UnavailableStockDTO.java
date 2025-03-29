package com.microservices.Inventory_Service.DTOs;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnavailableStockDTO  {
    private String skuCode;
    private BigDecimal requestedStock;
    private BigDecimal availableStock;
}

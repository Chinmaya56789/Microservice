package com.microservices.Order_Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

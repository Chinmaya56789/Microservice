package com.microservices.Order_Service.DTOs;


import com.microservices.Order_Service.Models.OrderLineItem;
import com.microservices.Order_Service.Models.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderResponseDTO {
    private String orderId;
    private OrderStatus orderStatus;
    private List<OrderLineItemDTO> orderLineItems;
}

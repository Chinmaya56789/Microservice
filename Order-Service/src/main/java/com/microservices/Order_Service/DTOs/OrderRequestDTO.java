package com.microservices.Order_Service.DTOs;


import com.microservices.Order_Service.Models.OrderLineItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderRequestDTO {
    private List<OrderLineItemDTO> orderLineItems;

}

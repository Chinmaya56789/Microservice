package com.microservices.Order_Service.Utilities;

import com.microservices.Order_Service.DTOs.OrderResponseDTO;
import com.microservices.Order_Service.DTOs.OrderLineItemDTO;
import com.microservices.Order_Service.DTOs.StockeCheckDTO;
import com.microservices.Order_Service.DTOs.UnavailableStockDTO;
import com.microservices.Order_Service.Models.Order;
import com.microservices.Order_Service.Models.OrderLineItem;

import java.math.BigDecimal;
import java.util.List;

public interface GetDTO {
    static OrderLineItem fromOrderLineDTO(OrderLineItemDTO o){
        return OrderLineItem.builder().skuCode(o.getSkuCode()).price(o.getPrice()).qunatity(o.getQunatity()).build();
    }
    static OrderLineItemDTO fromOrderLineItems(OrderLineItem item){
        return OrderLineItemDTO.builder().price(item.getPrice()).qunatity(item.getQunatity()).skuCode(item.getSkuCode()).build();
    }
    static OrderResponseDTO fromOrder(Order o){
        List<OrderLineItemDTO> lineitems= o.getOrderLineItems().stream().map(GetDTO::fromOrderLineItems).toList();
        return OrderResponseDTO.builder().orderId(o.getOrderId()).orderLineItems(lineitems).orderStatus(o.getOrderStatus()).build();
    }
    static StockeCheckDTO fromLineItemtoStockCheck(OrderLineItem o){
        return StockeCheckDTO.builder().requestedQuantity(BigDecimal.valueOf(o.getQunatity())).skuCode(o.getSkuCode()).build();
    }
    static OrderLineItemDTO fromUnavtoOrderLineDto(UnavailableStockDTO o){
        return OrderLineItemDTO.builder().skuCode(o.getSkuCode()).qunatity(o.getAvailableStock().longValue()).build();
    }
    
}

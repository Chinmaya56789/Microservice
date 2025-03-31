package com.microservices.Order_Service.Services;


import com.microservices.Order_Service.DTOs.*;
import com.microservices.Order_Service.Models.Order;
import com.microservices.Order_Service.Models.OrderLineItem;
import com.microservices.Order_Service.Models.OrderStatus;
import com.microservices.Order_Service.Repositories.OrderRepository;
import com.microservices.Order_Service.Utilities.GetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepo;
    private WebClient.Builder webClient;

    public OrderResponseDTO placeOrder(OrderRequestDTO o){
            List<OrderLineItem> items=o.getOrderLineItems().stream().map(GetDTO::fromOrderLineDTO).toList();
            List<StockeCheckDTO> skus= items.stream().map(GetDTO::fromLineItemtoStockCheck).toList();

            //Call to Inventory Service to check Stock
        List<UnavailableStockDTO> stockCheckResponse = webClient.build().post()
                .uri("http://inventory-service/inventory/sku-stock")
                .bodyValue(skus)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UnavailableStockDTO>>() {})
                .block();

        if (stockCheckResponse.isEmpty()){
            Order order = Order.builder().orderId(UUID.randomUUID().toString()).orderLineItems(items).orderStatus(OrderStatus.CREATED).build();
            orderRepo.save(order);
            return GetDTO.fromOrder(order);
        }
        List<OrderLineItemDTO> lineDTO= stockCheckResponse.stream().map(GetDTO::fromUnavtoOrderLineDto).toList();
        return OrderResponseDTO.builder().orderStatus(OrderStatus.CANCALLED).orderLineItems(lineDTO).build();

    }
    public OrderResponseDTO getOrderDetails(String id){
                Order order= orderRepo.findByOrderId(id).orElse(null);
        assert order != null;
        return GetDTO.fromOrder(order);
    }

    public OrderResponseDTO orderDelivered(String orderId) {
        Order order = orderRepo.findByOrderId(orderId).orElse(null);
        order.setOrderStatus(OrderStatus.DELIVERED);
        orderRepo.save(order);

        return GetDTO.fromOrder(order);
    }
}

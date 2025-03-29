package com.microservices.Order_Service.Controllers;


import com.microservices.Order_Service.DTOs.OrderResponseDTO;
import com.microservices.Order_Service.DTOs.OrderRequestDTO;
import com.microservices.Order_Service.Services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("order/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequestDTO order){
        OrderResponseDTO response = orderService.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("order/getOrderDetails/{orderId}")
    public ResponseEntity<?> getOrderStatus(@PathVariable("orderId")  String orderId){
        OrderResponseDTO response = orderService.getOrderDetails(orderId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PatchMapping("order/delivered/{orderId}")
    public ResponseEntity<?> getOrderDelivered(@PathVariable("orderId")  String orderId){
        OrderResponseDTO response = orderService.orderDelivered(orderId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

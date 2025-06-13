package com.user.controller;

import gov.iti.jets.user.dto.OrderDTO;
import gov.iti.jets.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") Long id) {

        OrderDTO order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getAllOrders(@PathVariable("userId") Long userId) {

        List<OrderDTO> orders = orderService.getAllOrders(userId);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {

        OrderDTO createdOrder = orderService.addOrder(orderDTO);
        System.out.println(orderDTO.getUserId() + " " + "asdasd");
        return ResponseEntity.ok(createdOrder);
    }
}

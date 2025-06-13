package com.user.service;

import gov.iti.jets.user.client.ProductClient;
import gov.iti.jets.user.client.ProductClientFeign;
import gov.iti.jets.user.dto.OrderDTO;
import gov.iti.jets.user.dto.ProductDTO;
import gov.iti.jets.user.entity.Order;
import gov.iti.jets.user.mappers.OrderMapper;
import gov.iti.jets.user.repo.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private ProductClientFeign productClientFeign;

    public List<ProductDTO> getProductsOrderId(Long id) {
        log.info("Fetching products for order ID: {}", id);
        ProductDTO[] products = productClientFeign.getproducts(id);
        if (products != null) {
            return List.of(products);
        } else {
            log.warn("No products found for order ID: {}", id);
            return List.of();
        }

    }

    public List<ProductDTO> addProducts(List<ProductDTO> products) {
        log.info("Adding products to order");
        ProductDTO[] response = productClientFeign.getAllProducts();


        if (response != null) {
            return List.of(response);
        } else {
            log.warn("No products added");
            return List.of();
        }
    }
    public List<OrderDTO> getOrdersUserId(Long userId) {
        log.info("Fetching orders for user ID: {}", userId);
        List<OrderDTO> orders = orderMapper.toOrderDTO(orderRepo.findByUserId(userId));
        orders.forEach(order -> {order.setOrderDetails(getProductsOrderId(order.getOrderId()));});
        if (orders.isEmpty()) {
            log.warn("No orders found for user ID: {}", userId);
        }
        return orders;
    }

    public OrderDTO getOrderById(Long orderId) {
        log.info("Fetching order by ID: {}", orderId);
       OrderDTO orderDTO = orderMapper.toOrderDTO(orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId)));
        orderDTO.setOrderDetails(getProductsOrderId(orderId));
        System.out.println(orderDTO.getOrderId());
        return orderDTO;
    }

    public OrderDTO addOrder(OrderDTO order) {
        log.info("Adding orders");
        List<ProductDTO> products = order.getOrderDetails();
        order.setOrderDetails(products);
        Order order1 = orderMapper.toOrder(order);
        System.out.println(order1.getUserId() + " " + order.getUserId());
        order.setOrderId( orderRepo.save(order1).getOrderId());
        log.info("Order added successfully with ID: {}", order.getOrderId());
        return order;

    }

    public List<OrderDTO> getAllOrders(long userId) {
    log.info("Fetching all orders for user ID: {}", userId);
        List<Order> orders = orderRepo.findByUserId(userId);
        List<OrderDTO> userOrders = orders.stream().map(order -> getOrderById(order.getOrderId())).collect(Collectors.toList());

        if (userOrders.isEmpty()) {
            log.warn("No orders found for user ID: {}", userId);
        }
        return userOrders;
    }
}

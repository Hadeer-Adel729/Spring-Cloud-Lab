package com.user.client;

import gov.iti.jets.user.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORDERSERVICE")
public interface OrderClientFeign {
    @GetMapping("/api/orders/user/{id}")
    OrderDTO[] getOrders(@PathVariable Long id);
}

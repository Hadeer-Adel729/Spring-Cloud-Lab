package com.user.client;

import gov.iti.jets.user.dto.OrderDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderClient {

    private RestTemplate restTemplate = new RestTemplate();

    public OrderDTO[] getOrders(Long id) {
        String url = "http://localhost:8082/api/orders/user/" + id;
        return restTemplate.getForObject(url, OrderDTO[].class);
    }
}

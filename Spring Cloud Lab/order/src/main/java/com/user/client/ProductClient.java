package com.user.client;

import gov.iti.jets.user.dto.ProductDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {
    private RestTemplate restTemplate = new RestTemplate();

    public ProductDTO[] getproducts(Long id){
        String url = "http://localhost:8083/api/products/order/" + id;
        ProductDTO[] products = restTemplate.getForObject(url, ProductDTO[].class);
        return products;
    }

    public ProductDTO[] getAllProducts() {
        String url = "http://localhost:8083/api/products";
        ProductDTO[] products = restTemplate.getForObject(url, ProductDTO[].class);
        return products;
    }
}

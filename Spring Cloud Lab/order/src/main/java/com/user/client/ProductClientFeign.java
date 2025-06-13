package com.user.client;

import gov.iti.jets.user.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCTSERVICE")
public interface ProductClientFeign {
    @GetMapping("/api/products/order/{id}")
    ProductDTO[] getproducts(@PathVariable("id") Long id);

    @GetMapping("/api/products")
    ProductDTO[] getAllProducts();

    @GetMapping("/api/products/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);
}

package com.user.controller;

import gov.iti.jets.user.dto.ProductDTO;
import gov.iti.jets.user.entity.Product;
import gov.iti.jets.user.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/order/{id}")
    public ResponseEntity<List<ProductDTO>> getProductById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(productService.getProductsOrderId(id));
    }

    @PostMapping
    public ResponseEntity<List<ProductDTO>> addProducts(@RequestBody List<ProductDTO> products) {
        List<ProductDTO> productDTOs = productService.addProducts(products);
        return ResponseEntity.ok(productDTOs);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}

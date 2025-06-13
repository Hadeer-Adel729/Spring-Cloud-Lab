package com.user.service;

import gov.iti.jets.user.dto.ProductDTO;
import gov.iti.jets.user.entity.Product;
import gov.iti.jets.user.mappers.ProductMapper;
import gov.iti.jets.user.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> getProductsOrderId(Long id) {
        log.info("Fetching all products");
        return productMapper.toProductDTO(productRepo.findByOrderId(id));
    }

    public List<ProductDTO> addProducts(List<ProductDTO> products) {
        log.info("Adding products");
        List<Product> productEntities = productMapper.toProduct(products);
        productRepo.saveAll(productEntities);
        return productMapper.toProductDTO(productEntities);
    }

    public List<ProductDTO> getAllProducts() {
        log.info("Fetching all products");
        return productMapper.toProductDTO(productRepo.findAll());
    }


}

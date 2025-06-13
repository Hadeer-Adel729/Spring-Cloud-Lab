package com.user.repo;

import gov.iti.jets.user.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

     List<Product> findByOrderId(Long id);
}

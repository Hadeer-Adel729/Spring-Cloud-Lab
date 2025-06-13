package com.user.mappers;


import gov.iti.jets.user.dto.ProductDTO;
import gov.iti.jets.user.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);
    Product toProduct(ProductDTO productDTO);

    List<ProductDTO> toProductDTO(List<Product> product);
    List<Product> toProduct(List<ProductDTO> productDTO);
}

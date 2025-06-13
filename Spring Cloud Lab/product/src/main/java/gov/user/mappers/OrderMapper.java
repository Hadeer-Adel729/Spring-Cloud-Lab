package com.user.mappers;

import gov.iti.jets.user.dto.OrderDTO;
import gov.iti.jets.user.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toOrderDTO(Product order);
    Product toOrder(OrderDTO orderDTO);

    List<OrderDTO> toOrderDTO(List<Product> orders);
    List<Product> toOrder(List<OrderDTO> orderDTOs);
}

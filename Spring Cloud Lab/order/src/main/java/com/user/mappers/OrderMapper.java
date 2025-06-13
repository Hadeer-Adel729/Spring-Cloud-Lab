package com.user.mappers;

import gov.iti.jets.user.dto.OrderDTO;
import gov.iti.jets.user.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);

    List<OrderDTO> toOrderDTO(List<Order> orders);
    List<Order> toOrder(List<OrderDTO> orderDTOs);
}

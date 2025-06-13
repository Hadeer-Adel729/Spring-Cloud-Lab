package com.user.dto;

import gov.iti.jets.user.enums.OrderStatus;
import gov.iti.jets.user.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long orderId;

    private String address;

    private BigDecimal price;

    private Date date;

    private OrderStatus status;

    private PayType payType;

    private Long userId;

    private List<ProductDTO> orderDetails;
}

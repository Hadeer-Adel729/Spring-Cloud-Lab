package com.user.dto;

import gov.iti.jets.user.enums.OrderStatus;
import gov.iti.jets.user.enums.PayType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {
    private Long orderId;

    private String address;

    private BigDecimal price;

    private Date date;
    private OrderStatus status;

    private PayType payType;

    private Long userId;

    private List<ProductDTO> orderDetails;
}

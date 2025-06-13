package com.user.entity;

import gov.iti.jets.user.enums.OrderStatus;
import gov.iti.jets.user.enums.PayType;
import gov.iti.jets.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "date", nullable = false)
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "payType", nullable = false)
    private PayType payType;

    @Column(name = "userId", nullable = false)
    private Long userId;


}

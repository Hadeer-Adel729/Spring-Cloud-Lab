package com.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import gov.iti.jets.user.dto.OrderDTO;
import gov.iti.jets.user.enums.UserRole;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "userName", nullable = false )
//    @NotEmpty
    private String userName;

    @Column(name = "email", nullable = false, unique = true)
//    @Email
//    @NotEmpty
    private String email;

    @Column(name = "password", nullable = false)
//    @NotEmpty
    private String password;

    @Column(name = "birthdate")
    private Date BD;

    @Column(name = "job")
    private String job;

    @Column(name = "creditNo")
    private String creditNo;

    @Column(name = "creditLimit")
    private BigDecimal creditLimit;

    @Column(name = "phone")
    private String phone;



}
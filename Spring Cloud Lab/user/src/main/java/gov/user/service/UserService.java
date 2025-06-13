package com.user.service;

import gov.iti.jets.user.client.OrderClient;
import gov.iti.jets.user.client.OrderClientFeign;
import gov.iti.jets.user.dto.OrderDTO;
import gov.iti.jets.user.dto.UserDTO;
import gov.iti.jets.user.entity.User;
import gov.iti.jets.user.mappers.UserMapper;
import gov.iti.jets.user.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderClientFeign orderClient;

    public List<UserDTO> findAll() {
        log.info("Fetching all users");
        List<User> users = userRepo.findAll();
        List<UserDTO> userDTOs = userMapper.toUserDTOs(users);
        userDTOs.forEach(userDTO -> {
            OrderDTO[] orders = orderClient.getOrders(userDTO.getUserId());
            userDTO.setOrders(List.of(orders));
        });
        if (users.isEmpty()) {
            log.warn("No users found");
        } else {
            log.info("Found {} users", users.size());
        }
        return userDTOs;
    }

    public UserDTO findById(Long id) {
        log.info("Fetching user with ID: {}", id);
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        UserDTO userDTO = userMapper.toUserDTO(user);
        OrderDTO[] orders = orderClient.getOrders(user.getUserId());
        userDTO.setOrders(List.of(orders));
        return userDTO;
    }
}

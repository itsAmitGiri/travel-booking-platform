package com.travel_booking_platform.user_service.service;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.dto.UserResponseDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;

import java.util.Optional;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO user);
    UserResponseDTO getUserById(int id);
    Optional<UserEntity> findByUserName(String username);
}

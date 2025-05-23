package com.travel_booking_platform.user_service.serviceImpl;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.dto.UserResponseDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;
import com.travel_booking_platform.user_service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserResponseDTO createUser(UserRequestDTO user) {
        return null;
    }

    @Override
    public UserResponseDTO getUserById(int id) {
        return null;
    }

    @Override
    public Optional<UserEntity> findByUserName(String username) {
        return Optional.empty();
    }
}

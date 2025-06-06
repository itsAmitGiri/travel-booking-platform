package com.travel_booking_platform.user_service.strategy;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;

public interface UserRegistrationStrategy {
    UserEntity registerUser(UserRequestDTO requestDTO);
}

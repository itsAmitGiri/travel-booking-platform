package com.travel_booking_platform.user_service.strategy;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;
import com.travel_booking_platform.user_service.enums.UserType;

public class AdminUserRegistrationStrategy implements UserRegistrationStrategy{
    @Override
    public UserEntity registerUser(UserRequestDTO requestDTO) {
        return new UserEntity(requestDTO.userName(),
                requestDTO.email(),
                requestDTO.password(),
                UserType.ADMIN);
    }
}

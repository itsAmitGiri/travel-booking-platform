package com.travel_booking_platform.user_service.strategy;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;
import com.travel_booking_platform.user_service.enums.UserType;
import org.springframework.stereotype.Component;

@Component("SOCIAL")
public class SocialUserCreationStrategy implements UserCreationStrategy {

    @Override
    public UserEntity createUser(UserRequestDTO dto) {
        return UserEntity.builder()
                .userName(dto.userName())
                .email(dto.email())
                .password("") // Social users don't need password
                .userType(UserType.SOCIAL)
                .build();
    }
}

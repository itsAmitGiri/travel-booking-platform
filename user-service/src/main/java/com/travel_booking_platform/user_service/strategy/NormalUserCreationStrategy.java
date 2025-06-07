package com.travel_booking_platform.user_service.strategy;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;
import com.travel_booking_platform.user_service.enums.UserType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("NORMAL")
public class NormalUserCreationStrategy implements UserCreationStrategy {

    private final PasswordEncoder passwordEncoder;

    public NormalUserCreationStrategy(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity createUser(UserRequestDTO dto) {
        return UserEntity.builder()
                .userName(dto.userName())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .userType(UserType.NORMAL)
                .build();
    }
}

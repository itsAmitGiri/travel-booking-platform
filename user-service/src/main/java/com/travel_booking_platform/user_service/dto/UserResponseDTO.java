package com.travel_booking_platform.user_service.dto;

import com.travel_booking_platform.user_service.enums.Role;

import java.time.LocalDateTime;

public class UserResponseDTO {
    private Long id;
    private String username;
    private Role role;
    private LocalDateTime createdAt;
}

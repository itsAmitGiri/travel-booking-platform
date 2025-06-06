package com.travel_booking_platform.user_service.dto;

import com.travel_booking_platform.user_service.enums.UserType;
import lombok.Data;

public record UserRequestDTO(String userName, String email, String password, UserType userType) {
}

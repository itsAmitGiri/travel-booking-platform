package com.travel_booking_platform.user_service.mapper;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.dto.UserResponseDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserRequestDTO dto);
    UserResponseDTO toDto(UserEntity user);
}

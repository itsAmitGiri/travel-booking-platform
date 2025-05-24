package com.travel_booking_platform.user_service.serviceImpl;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.dto.UserResponseDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;
import com.travel_booking_platform.user_service.exceptions.UserNotFoundException;
import com.travel_booking_platform.user_service.mapper.UserMapper;
import com.travel_booking_platform.user_service.repository.UserRepository;
import com.travel_booking_platform.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;
    @Autowired
    UserRepository repository;
    @Override
    public UserResponseDTO createUser(UserRequestDTO user) {
        UserEntity userEntity = mapper.toEntity(user);
        repository.save(userEntity);
        return mapper.toDto(userEntity);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        Optional<UserEntity> user = repository.findById(id);
        if (user.isPresent())
            return mapper.toDto(user.get());
        else
            throw new UserNotFoundException("No user present with id: " +id);
    }

    @Override
    public UserResponseDTO findByUserName(String username) {
        Optional<UserEntity> user = repository.findByUsername(username);
        if (user.isPresent())
            return mapper.toDto(user.get());
        else
            throw new UserNotFoundException("No user present with username: " +username);
    }
}

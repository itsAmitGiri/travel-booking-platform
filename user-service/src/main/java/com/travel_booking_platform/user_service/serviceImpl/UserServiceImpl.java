package com.travel_booking_platform.user_service.serviceImpl;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.dto.UserResponseDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;
import com.travel_booking_platform.user_service.exceptions.UserNotFoundException;
import com.travel_booking_platform.user_service.factory.UserStrategyFactory;
import com.travel_booking_platform.user_service.mapper.UserMapper;
import com.travel_booking_platform.user_service.repository.UserRepository;
import com.travel_booking_platform.user_service.service.UserService;
import com.travel_booking_platform.user_service.strategy.UserRegistrationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;
    @Autowired
    UserRepository repository;
    private final UserRepository userRepository;
    private final UserStrategyFactory strategyFactory;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserStrategyFactory strategyFactory) {
        this.userRepository = userRepository;
        this.strategyFactory = strategyFactory;
    }
    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        UserRegistrationStrategy strategy = strategyFactory.getStrategy(userRequestDTO.userType());
        UserEntity user = strategy.registerUser(userRequestDTO);
        user = userRepository.save(user);

        return new UserResponseDTO(user.getId(), user.getUserName(), user.getEmail(), "CREATED");
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
        Optional<UserEntity> user = repository.findByUserName(username);
        if (user.isPresent())
            return mapper.toDto(user.get());
        else
            throw new UserNotFoundException("No user present with username: " +username);
    }
}

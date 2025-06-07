package com.travel_booking_platform.user_service.service;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.dto.UserResponseDTO;
import com.travel_booking_platform.user_service.entities.UserEntity;
import com.travel_booking_platform.user_service.exceptions.UserNotFoundException;
import com.travel_booking_platform.user_service.factory.UserCreationStrategyFactory;
import com.travel_booking_platform.user_service.repository.UserRepository;
import com.travel_booking_platform.user_service.strategy.UserCreationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCreationStrategyFactory strategyFactory;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserCreationStrategyFactory strategyFactory) {
        this.userRepository = userRepository;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        UserCreationStrategy strategy = strategyFactory.getStrategy(dto.userType());
        UserEntity userEntity = strategy.createUser(dto);
        userEntity = userRepository.save(userEntity);
        return new UserResponseDTO(userEntity.getId(), userEntity.getUserName(), userEntity.getEmail(), userEntity.getUserType().name());
    }

    @Override
    public Optional<UserResponseDTO> getUserById(long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("No user found with id : " +id);
        return Optional.of(new UserResponseDTO(user.get().getId(), user.get().getUserName(),
                user.get().getEmail(), user.get().getUserType().toString()));
    }

}

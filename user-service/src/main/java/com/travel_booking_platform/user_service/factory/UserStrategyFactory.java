package com.travel_booking_platform.user_service.factory;

import com.travel_booking_platform.user_service.enums.UserType;
import com.travel_booking_platform.user_service.strategy.UserRegistrationStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class UserStrategyFactory {
    private final Map<String, UserRegistrationStrategy> strategies;

    @Autowired
    public UserStrategyFactory(Map<String, UserRegistrationStrategy> strategies) {
        this.strategies = strategies;
    }

    public UserRegistrationStrategy getStrategy(UserType userType) {
        return strategies.get(userType.name());
    }
}

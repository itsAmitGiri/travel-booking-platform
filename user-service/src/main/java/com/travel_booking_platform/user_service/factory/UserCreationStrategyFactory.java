package com.travel_booking_platform.user_service.factory;

import com.travel_booking_platform.user_service.strategy.UserCreationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserCreationStrategyFactory {

    private final Map<String, UserCreationStrategy> strategyMap;

    @Autowired
    public UserCreationStrategyFactory(Map<String, UserCreationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public UserCreationStrategy getStrategy(String userType) {
        return strategyMap.get(userType.toUpperCase());
    }
}

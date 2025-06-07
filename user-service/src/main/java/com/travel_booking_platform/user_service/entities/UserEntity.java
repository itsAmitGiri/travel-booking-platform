package com.travel_booking_platform.user_service.entities;

import com.travel_booking_platform.user_service.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}

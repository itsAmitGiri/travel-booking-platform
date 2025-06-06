package com.travel_booking_platform.user_service.entities;

import com.travel_booking_platform.user_service.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public UserEntity() {}

    // All-arg constructor
    public UserEntity(Long id, String userName, String email, String password, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    // Custom constructor without ID
    public UserEntity(String userName, String email, String password, UserType userType) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}

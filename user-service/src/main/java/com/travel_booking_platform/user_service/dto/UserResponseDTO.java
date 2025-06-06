package com.travel_booking_platform.user_service.dto;

public class UserResponseDTO {
    private Long id;
    private String userName;
    private String email;
    private String status;

    public UserResponseDTO(){}

    public UserResponseDTO(Long id, String userName, String email, String status) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.status = status;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

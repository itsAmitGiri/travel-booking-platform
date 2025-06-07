package com.travel_booking_platform.user_service.controller;

import com.travel_booking_platform.user_service.dto.UserRequestDTO;
import com.travel_booking_platform.user_service.dto.UserResponseDTO;
import com.travel_booking_platform.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/public/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @GetMapping("/get/user/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable long id){
        return ResponseEntity.ok(userService.getUserById(id).get());
    }
}

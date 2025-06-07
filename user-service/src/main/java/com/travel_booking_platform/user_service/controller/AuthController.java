package com.travel_booking_platform.user_service.controller;

import com.travel_booking_platform.user_service.dto.AuthRequest;
import com.travel_booking_platform.user_service.dto.AuthResponse;
import com.travel_booking_platform.user_service.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/public")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request){
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        String token = jwtUtils.generateToken(request.username());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}

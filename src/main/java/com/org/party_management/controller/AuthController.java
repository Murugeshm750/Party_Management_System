package com.org.party_management.controller;

import com.org.party_management.dto.request.LoginRequest;
import com.org.party_management.dto.response.ApiResponse;
import com.org.party_management.dto.response.LoginResponse;
import com.org.party_management.dto.response.UserLoginResponse;
import com.org.party_management.model.UserLogin;
import com.org.party_management.repository.UserLoginRepository;
import com.org.party_management.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserLoginRepository userLoginRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {

        UserLogin user = userLoginRepository.findByUserLoginId(request.getUserLoginId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean passwordMatches = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!passwordMatches) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtService.generateToken(user.getUserLoginId());


        return ApiResponse.success(HttpStatus.OK.value(), "" , new LoginResponse(token, user.getRoleTypeId(), user.getUserLoginId(), user.getPartyId()));
    }
}
package com.org.party_management.controller;

import com.org.party_management.dto.request.UserLoginPatchRequest;
import com.org.party_management.dto.request.UserLoginRequest;
import com.org.party_management.dto.response.ApiResponse;
import com.org.party_management.dto.response.UserLoginResponse;
import com.org.party_management.service.UserLoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/users")
@RequiredArgsConstructor
public class UserLoginController {
    private final UserLoginService userLoginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserLoginResponse> createUser(@Valid @RequestBody UserLoginRequest request){
        UserLoginResponse response = userLoginService.createUser(request);
        return ApiResponse.success(HttpStatus.CREATED.value(), "User Created Successfully.",response);
    }

    @PatchMapping("/{partyId}")
    public  ApiResponse<UserLoginResponse> updateUser(@PathVariable Long partyId,@Valid @RequestBody UserLoginPatchRequest request){
        UserLoginResponse response = userLoginService.updateUser(partyId, request);
        return ApiResponse.success(HttpStatus.OK.value(),"User Updated Successfully",response);
    }

    @GetMapping("/{partyId}")
    public ApiResponse<UserLoginResponse> getUserById(@PathVariable Long partyId){
        UserLoginResponse response = userLoginService.getUserById(partyId);
        return ApiResponse.success(HttpStatus.OK.value(), "",response);
    }

    @GetMapping
    public ApiResponse<List<UserLoginResponse>> getAllUsers(){
        List<UserLoginResponse> response = userLoginService.getAllUsers();
        return ApiResponse.success(HttpStatus.OK.value(), "",response);
    }

}

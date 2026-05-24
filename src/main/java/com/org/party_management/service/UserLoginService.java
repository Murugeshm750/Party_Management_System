package com.org.party_management.service;

import com.org.party_management.dto.request.UserLoginPatchRequest;
import com.org.party_management.dto.request.UserLoginRequest;
import com.org.party_management.dto.response.UserLoginResponse;
import com.org.party_management.model.UserLogin;

import java.util.List;


public interface UserLoginService {
    UserLoginResponse createUser(UserLoginRequest request);
    UserLoginResponse updateUser(Long partyId, UserLoginPatchRequest request);
    UserLoginResponse getUserById(Long partyId);
    List<UserLoginResponse> getAllUsers();
//    UserLogin loadUserLoginByUsername(String userLoginId);
}

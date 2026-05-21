package com.org.party_management.mapper;

import com.org.party_management.dto.request.UserLoginPatchRequest;
import com.org.party_management.dto.request.UserLoginRequest;
import com.org.party_management.dto.response.UserLoginResponse;
import com.org.party_management.model.UserLogin;
import org.springframework.stereotype.Component;

@Component
public class UserLoginMapper {

    public UserLogin createUserLogin(UserLoginRequest request){
        return UserLogin.builder()
                .userLoginId(request.getUserName())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .build();
    }

    public UserLoginResponse userLoginResponse(UserLogin userLogin){
        return UserLoginResponse.builder()
                .partyId(userLogin.getPartyId())
                .userLoginId(userLogin.getUserLoginId())
                .firstName(userLogin.getFirstName())
                .middleName(userLogin.getMiddleName())
                .lastName(userLogin.getLastName())
                .build();
    }


    public void updateUserLogin(
            UserLogin userLogin,
            UserLoginPatchRequest request
    ) {

        if (request.getUserName() != null &&
                !request.getUserName().isBlank()) {

            userLogin.setUserLoginId(
                    request.getUserName()
            );
        }

        if (request.getFirstName() != null &&
                !request.getFirstName().isBlank()) {

            userLogin.setFirstName(
                    request.getFirstName()
            );
        }

        if (request.getMiddleName() != null) {

            userLogin.setMiddleName(
                    request.getMiddleName()
            );
        }

        if (request.getLastName() != null &&
                !request.getLastName().isBlank()) {

            userLogin.setLastName(
                    request.getLastName()
            );
        }
    }

}

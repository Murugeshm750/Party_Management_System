package com.org.party_management.mapper;

import com.org.party_management.dto.request.UserLoginPatchRequest;
import com.org.party_management.dto.request.UserLoginRequest;
import com.org.party_management.dto.response.UserLoginResponse;
import com.org.party_management.exception.ResourceNotFoundException;
import com.org.party_management.model.Party;
import com.org.party_management.model.PartyRole;
import com.org.party_management.model.UserLogin;
import com.org.party_management.repository.PartyRepository;
import com.org.party_management.repository.PartyRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserLoginMapper {

    private final PartyRoleRepository partyRoleRepository;
    private final PartyRepository partyRepository;

    public UserLogin createUserLogin(UserLoginRequest request){
        return UserLogin.builder()
                .userLoginId(request.getUserName())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .roleTypeId(request.getRoleTypeId())
                .build();
    }

    public UserLoginResponse userLoginResponse(UserLogin userLogin){
        PartyRole partyRole = partyRoleRepository.findById(userLogin.getRoleTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Role Not Found"));

        Party party = partyRepository.findById(userLogin.getPartyId())
                .orElseThrow(() -> new RuntimeException("Party Not Found"));

        return UserLoginResponse.builder()
                .partyId(userLogin.getPartyId())
                .userLoginId(userLogin.getUserLoginId())
                .firstName(userLogin.getFirstName())
                .middleName(userLogin.getMiddleName())
                .lastName(userLogin.getLastName())
                .role(partyRole.getDescription())
                .partyGroupId(party.getParentPartyId())
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

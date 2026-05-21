package com.org.party_management.service.impl;


import com.org.party_management.dto.request.PartyRequest;
import com.org.party_management.dto.request.UserLoginPatchRequest;
import com.org.party_management.dto.request.UserLoginRequest;
import com.org.party_management.dto.response.UserLoginResponse;
import com.org.party_management.exception.ResourceNotFoundException;
import com.org.party_management.mapper.PartyMapper;
import com.org.party_management.mapper.UserLoginMapper;
import com.org.party_management.model.Party;
import com.org.party_management.model.UserLogin;
import com.org.party_management.repository.PartyRepository;
import com.org.party_management.repository.UserLoginRepository;
import com.org.party_management.service.UserLoginService;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {

    private final UserLoginRepository userLoginRepository;
    private final UserLoginMapper userLoginMapper;

    private final PartyRepository partyRepository;
    private final PartyMapper partyMapper;



    @Override
    public UserLoginResponse createUser(UserLoginRequest request) {

        PartyRequest partyRequest = new PartyRequest();
        partyRequest.setPreferredCurrencyUomId("INR");
        partyRequest.setPartyTypeId("PARTY_PERSON");
        partyRequest.setStatusId("PARTY_ENABLED");
        Party party = partyMapper.toEntity(partyRequest);
        Party savedParty = partyRepository.save(party);

        UserLogin userLogin = userLoginMapper.createUserLogin(request);
        userLogin.setParty(savedParty);

        UserLogin savedUserLogin = userLoginRepository.saveAndFlush(userLogin);

        return userLoginMapper.userLoginResponse(savedUserLogin);
    }

    @Override
    public UserLoginResponse updateUser(Long partyId, UserLoginPatchRequest request) {
        UserLogin userLogin = userLoginRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("User No Found"));

        userLoginMapper.updateUserLogin(userLogin, request);
        UserLogin updatedUserLogin = userLoginRepository.save(userLogin);
        return userLoginMapper.userLoginResponse(updatedUserLogin);
    }

    @Override
    public UserLoginResponse getUserById(Long partyId) {
        UserLogin userLogin = userLoginRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("User NOt Found"));

        return userLoginMapper.userLoginResponse(userLogin);
    }

    @Override
    public List<UserLoginResponse> getAllUsers() {
        return userLoginRepository.findAll()
                .stream()
                .map(userLoginMapper::userLoginResponse)
                .toList();
    }
}

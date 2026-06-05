package com.org.party_management.service.impl;

import com.org.party_management.model.PartyRole;
import com.org.party_management.repository.PartyRoleRepository;
import com.org.party_management.service.PartyRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyRoleServiceImpl implements PartyRoleService {

    private final PartyRoleRepository partyRoleRepository;

    @Override
    public List<PartyRole> getAllRole() {

       return partyRoleRepository.findAll();

//        return List.of((PartyRoleResponse) partyRoleList);
    }
}

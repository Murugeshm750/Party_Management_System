package com.org.party_management.service.impl;

import com.org.party_management.dto.request.PartyGroupRequest;
import com.org.party_management.dto.request.PartyRequest;
import com.org.party_management.dto.response.PartyGroupResponse;
import com.org.party_management.exception.ResourceNotFoundException;
import com.org.party_management.mapper.PartyGroupMapper;
import com.org.party_management.mapper.PartyMapper;
import com.org.party_management.model.Party;
import com.org.party_management.model.PartyGroup;
import com.org.party_management.repository.PartyGroupRepository;
import com.org.party_management.repository.PartyRepository;
import com.org.party_management.service.PartyGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyGroupServiceImpl implements PartyGroupService {

    private final PartyGroupMapper partyGroupMapper;
    private final PartyGroupRepository partyGroupRepository;

    private final PartyMapper partyMapper;
    private final PartyRepository partyRepository;

    @Override
    public PartyGroupResponse createPartyGroup(PartyGroupRequest request) {

        //create a new party in party table
        PartyRequest partyRequest = new PartyRequest();
        partyRequest.setPartyTypeId("PARTY_GROUP");
        partyRequest.setStatusId("PARTY_ENABLED");
        partyRequest.setPreferredCurrencyUomId("INR");
        Party party = partyMapper.toEntity(partyRequest);
        Party savedParty = partyRepository.save(party);

        PartyGroup partyGroup = partyGroupMapper.toEntity(request);
        // IMPORTANT
        partyGroup.setParty(savedParty);

        PartyGroup savedPartyGroup = partyGroupRepository.saveAndFlush(partyGroup);
        return partyGroupMapper.toResponse(savedPartyGroup);
    }

    @Override
    public PartyGroupResponse updatePartyGroup(Long partyId, PartyGroupRequest request) {
        PartyGroup partyGroup = partyGroupRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party Group Not Found"));
        partyGroupMapper.updateEntity(partyGroup, request);
        PartyGroup updatedPartyGroup = partyGroupRepository.save(partyGroup);
        return partyGroupMapper.toResponse(updatedPartyGroup);
    }

    @Override
    public PartyGroupResponse getPartyGroupById(Long partyId) {
        PartyGroup partyGroup = partyGroupRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party Group Not Found."));
        return partyGroupMapper.toResponse(partyGroup);
    }

    @Override
    public List<PartyGroupResponse> getAllPartyGroup() {

        return partyGroupRepository.findAll()
                .stream()
                .map(partyGroupMapper::toResponse)
                .toList();
    }

}

package com.org.party_management.service.impl;

import com.org.party_management.dto.request.PartyRequest;
import com.org.party_management.dto.response.PartyResponse;
import com.org.party_management.exception.ResourceNotFoundException;
import com.org.party_management.mapper.PartyMapper;
import com.org.party_management.model.Party;
import com.org.party_management.repository.PartyRepository;
import com.org.party_management.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {
    private final PartyRepository partyRepository;
    @Autowired
    private final PartyMapper partyMapper;

    @Override
    public PartyResponse createParty(PartyRequest request){
        Party party = partyMapper.toEntity(request);
        Party savedParty = partyRepository.save(party);
        return partyMapper.toResponse(savedParty);
    }

    @Override
    public PartyResponse updateParty(Long partyId, PartyRequest request) {
        Party party = partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party Not Found"));
        partyMapper.updateEntity(party, request);
        Party updatedParty = partyRepository.save(party);
        return partyMapper.toResponse(updatedParty);
    }

    @Override
    @Cacheable(value = "parties", key = "#partyId")
    public PartyResponse getPartyById(Long partyId) {

        Party party = partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party Not Found"));

        System.out.println("Fetching from DB");


        return partyMapper.toResponse(party);
    }

    @Override
    public List<PartyResponse> getAllParties() {
        return partyRepository.findAll()
                .stream()
                .map(partyMapper::toResponse)
                .toList();
    }

}

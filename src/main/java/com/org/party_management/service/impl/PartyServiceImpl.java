package com.org.party_management.service.impl;

import com.org.party_management.dto.PartyRequest;
import com.org.party_management.dto.PartyResponse;
import com.org.party_management.exception.ResourceNotFoundException;
import com.org.party_management.model.Party;
import com.org.party_management.repository.PartyRepository;
import com.org.party_management.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {
    private final PartyRepository partyRepository;

    @Override
    public PartyResponse createParty(PartyRequest request){
        Party party = Party.builder()
                .partyTypeId(request.getPartyTypeId())
                .preferredCurrencyUomId(request.getPreferredCurrencyUomId())
                .description(request.getDescription())
                .statusId(request.getStausId())
                .build();

        Party savedParty = partyRepository.save(party);
        return responseMap(savedParty);
    }

    @Override
    public PartyResponse updateParty(Long partyId, PartyRequest partyRequest) {
        Party party = partyRepository.findById(partyId)
                .orElseThrow(()-> new ResourceNotFoundException("Party Not Found"));
        party.setPartyTypeId(partyRequest.getPartyTypeId());
        party.setDescription(partyRequest.getDescription());
        party.setStatusId(partyRequest.getStausId());
        party.setPreferredCurrencyUomId(partyRequest.getPreferredCurrencyUomId());

        Party updatedParty = partyRepository.save(party);
        return responseMap(updatedParty);
    }

    @Override
    public PartyResponse getPartyById(Long partyId) {
        Party party = partyRepository.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party Id Not Found!."));

        return responseMap(party);
    }

    @Override
    public List<PartyResponse> getAllParties() {
        return partyRepository.findAll()
                .stream()
                .map(this::responseMap)
                .toList();
    }

    @Override
    public PartyResponse responseMap(Party party) {
        return PartyResponse.builder()
                .partyId(party.getPartyId())
                .partyTypeId(party.getPartyTypeId())
                .preferredCurrencyUomId(party.getPreferredCurrencyUomId())
                .description(party.getDescription())
                .statusId(party.getStatusId())
                .build();
    }
}

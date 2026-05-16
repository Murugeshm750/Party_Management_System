package com.org.party_management.service;


import com.org.party_management.dto.request.PartyRequest;
import com.org.party_management.dto.response.PartyResponse;
import com.org.party_management.model.Party;

import java.util.List;

public interface PartyService {
    PartyResponse createParty(PartyRequest partyRequest);
    PartyResponse updateParty(Long partyId, PartyRequest partyRequest);
    PartyResponse getPartyById(Long partyId);
    List<PartyResponse> getAllParties();
}

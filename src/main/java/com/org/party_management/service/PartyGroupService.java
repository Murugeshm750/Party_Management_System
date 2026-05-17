package com.org.party_management.service;

import com.org.party_management.dto.request.PartyGroupRequest;
import com.org.party_management.dto.response.PartyGroupResponse;
import com.org.party_management.model.PartyGroup;

import java.util.List;

public interface PartyGroupService {
    PartyGroupResponse createPartyGroup(PartyGroupRequest request);
    PartyGroupResponse updatePartyGroup(Long partyId, PartyGroupRequest request);
    PartyGroupResponse getPartyGroupById(Long partyId);
    List<PartyGroupResponse> getAllPartyGroup();
}

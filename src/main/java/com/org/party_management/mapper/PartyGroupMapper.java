package com.org.party_management.mapper;

import com.org.party_management.dto.request.PartyGroupRequest;
import com.org.party_management.dto.response.PartyGroupResponse;
import com.org.party_management.model.PartyGroup;
import org.springframework.stereotype.Component;

@Component
public class PartyGroupMapper {

    public PartyGroup toEntity(PartyGroupRequest request) {
        return PartyGroup.builder()
                .groupName(request.getGroupName())
                .description(request.getDescription())
                .build();
    }

    public PartyGroupResponse toResponse(PartyGroup partyGroup){
        return PartyGroupResponse.builder()
                .partyId(partyGroup.getPartyId())
                .groupName(partyGroup.getGroupName())
                .description(partyGroup.getDescription())
                .createdDate(partyGroup.getCreatedDate())
                .updatedDate(partyGroup.getUpdatedDate())
                .build();
    }

    public void updateEntity(PartyGroup partyGroup, PartyGroupRequest request){
        if (request.getGroupName() != null){
            partyGroup.setGroupName(request.getGroupName());
        }
        if (request.getDescription() != null){
            partyGroup.setDescription(request.getDescription());
        }

    }
}

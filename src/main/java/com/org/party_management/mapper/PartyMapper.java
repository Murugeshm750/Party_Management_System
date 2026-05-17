package com.org.party_management.mapper;

import com.org.party_management.dto.request.PartyRequest;
import com.org.party_management.dto.response.PartyResponse;
import com.org.party_management.model.Party;
import org.springframework.stereotype.Component;

@Component
public class PartyMapper {

    public Party toEntity(PartyRequest request) {

        return Party.builder()
                .partyTypeId(request.getPartyTypeId())
                .preferredCurrencyUomId(request.getPreferredCurrencyUomId())
                .description(request.getDescription())
                .statusId(request.getStatusId())
                .build();
    }

    public PartyResponse toResponse(Party party) {

        return PartyResponse.builder()
                .partyId(party.getPartyId())
                .partyTypeId(party.getPartyTypeId())
                .preferredCurrencyUomId(party.getPreferredCurrencyUomId())
                .description(party.getDescription())
                .statusId(party.getStatusId())
                .createdDate(party.getCreatedDate())
                .updatedDate(party.getUpdatedDate())
                .build();
    }

    public void updateEntity(
            Party party,
            PartyRequest request
    ) {

        party.setPartyTypeId(request.getPartyTypeId());
        party.setPreferredCurrencyUomId(request.getPreferredCurrencyUomId());
        party.setDescription(request.getDescription());
        party.setStatusId(request.getStatusId());
    }
}
package com.org.party_management.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartyResponse {
    private Long partyId;
    private String partyTypeId;
    private String preferredCurrencyUomId;
    private String description;
    private String statusId;

}

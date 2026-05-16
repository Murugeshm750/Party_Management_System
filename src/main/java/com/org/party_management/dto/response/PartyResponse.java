package com.org.party_management.dto.response;

import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}

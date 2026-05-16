package com.org.party_management.dto;

import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartyRequest {

    @NotBlank(message = "Party Type Cannot be Empty.")
    private String partyTypeId;

    private String preferredCurrencyUomId;

    private String description;

    @NotBlank(message = "Status Id Cannot be Empty.")
    private String stausId;


}

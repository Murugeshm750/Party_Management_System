package com.org.party_management.dto.request;

import com.org.party_management.model.ContactMechType;
import com.org.party_management.model.Party;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMechRequest {
    @NotNull
    private Long partyId;
    @NotBlank
    private String contactMechTypeId;
    @NotBlank
    private String contactValue;
}

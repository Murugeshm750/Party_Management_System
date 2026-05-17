package com.org.party_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartyGroupRequest {
    @NotBlank(message = "Group Name not be empty.")
    private String groupName;
    private String description;
}

package com.org.party_management.dto.response;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartyRoleResponse {
    private String roleTypeId;
    private String description;
}

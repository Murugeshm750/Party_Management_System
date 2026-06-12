package com.org.party_management.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactMechTypeResponse {
    private Long contactMechTypeId;
    private String description;
}

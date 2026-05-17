package com.org.party_management.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartyGroupResponse {
    private Long partyId;
    private String groupName;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

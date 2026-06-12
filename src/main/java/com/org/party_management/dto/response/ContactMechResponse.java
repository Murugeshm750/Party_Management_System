package com.org.party_management.dto.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactMechResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long contactMechId;
    private Long partyId;
    private String contactMechTypeId;
    private String contactValue;
    private LocalDateTime expireDate;
}

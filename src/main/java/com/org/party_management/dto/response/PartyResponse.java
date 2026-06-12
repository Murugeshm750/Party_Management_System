package com.org.party_management.dto.response;

import com.org.party_management.model.ContactMech;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartyResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long partyId;
    private String partyTypeId;
    private String preferredCurrencyUomId;
    private String description;
    private String statusId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private List<ContactMech> contacts;


}

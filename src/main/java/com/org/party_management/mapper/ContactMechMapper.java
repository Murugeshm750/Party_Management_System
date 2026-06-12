package com.org.party_management.mapper;

import com.org.party_management.dto.request.ContactMechRequest;
import com.org.party_management.dto.response.ContactMechResponse;
import com.org.party_management.model.ContactMech;
import org.springframework.stereotype.Component;

@Component
public class ContactMechMapper {

    public ContactMech createContact(ContactMechRequest request){
        return ContactMech.builder()
                .partyId(request.getPartyId())
                .contactMechTypeId(request.getContactMechTypeId())
                .contactValue(request.getContactValue())
                .build();
    }

    public ContactMechResponse contactMechResponse(ContactMech contactMech){
        return ContactMechResponse.builder()
                .contactMechId(contactMech.getContactMechId())
                .contactMechTypeId(contactMech.getContactMechTypeId())
                .partyId(contactMech.getPartyId())
                .contactValue(contactMech.getContactValue())
                .expireDate(contactMech.getExpireDate())
                .build();
    }
}

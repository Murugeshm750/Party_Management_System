package com.org.party_management.service.impl;

import com.org.party_management.dto.request.ContactMechRequest;
import com.org.party_management.dto.response.ContactMechResponse;
import com.org.party_management.mapper.ContactMechMapper;
import com.org.party_management.model.ContactMech;
import com.org.party_management.repository.ContactMechRepository;
import com.org.party_management.service.ContactMechService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMechServiceImpl implements ContactMechService {

    private final ContactMechMapper contactMechMapper;
    private final ContactMechRepository contactMechRepository;

    @Override
    @CacheEvict(value = "parties", key = "#request.partyId")
    public ContactMechResponse createContact(ContactMechRequest request) {

        ContactMech contactMech = contactMechMapper.createContact(request);
        ContactMech newEntity = contactMechRepository.save(contactMech);

        return contactMechMapper.contactMechResponse(newEntity);
    }
}

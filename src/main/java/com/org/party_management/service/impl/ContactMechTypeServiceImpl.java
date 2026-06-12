package com.org.party_management.service.impl;

import com.org.party_management.model.ContactMechType;
import com.org.party_management.repository.ContactMechTypeRepository;
import com.org.party_management.service.ContactMechTypeService;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactMechTypeServiceImpl implements ContactMechTypeService {

    private final ContactMechTypeRepository contactMechTypeRepository;

    @Override
    public List<ContactMechType> getAllContactMechTypes() {
        return contactMechTypeRepository.findAll();
    }
}

package com.org.party_management.service;

import com.org.party_management.dto.response.ContactMechTypeResponse;
import com.org.party_management.model.ContactMechType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContactMechTypeService {
    List<ContactMechType> getAllContactMechTypes();
}

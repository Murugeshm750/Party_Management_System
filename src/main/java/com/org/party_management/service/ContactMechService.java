package com.org.party_management.service;

import com.org.party_management.dto.request.ContactMechRequest;
import com.org.party_management.dto.response.ContactMechResponse;

public interface ContactMechService {

    ContactMechResponse createContact(ContactMechRequest request);
}

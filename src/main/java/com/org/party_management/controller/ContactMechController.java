package com.org.party_management.controller;

import com.org.party_management.dto.request.ContactMechRequest;
import com.org.party_management.dto.response.ApiResponse;
import com.org.party_management.dto.response.ContactMechResponse;
import com.org.party_management.service.ContactMechService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest/contact")
@RequiredArgsConstructor
public class ContactMechController {

    private final ContactMechService contactMechService;

    @PostMapping
    public ApiResponse<ContactMechResponse> createContact(ContactMechRequest request){
        ContactMechResponse response = contactMechService.createContact(request);
        return ApiResponse.success(HttpStatus.OK.value(), "Contact Created Successfully.", response );
    }

}

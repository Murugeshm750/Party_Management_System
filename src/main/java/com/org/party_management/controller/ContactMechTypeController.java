package com.org.party_management.controller;

import com.org.party_management.dto.response.ApiResponse;
import com.org.party_management.dto.response.ContactMechTypeResponse;
import com.org.party_management.model.ContactMechType;
import com.org.party_management.repository.ContactMechTypeRepository;
import com.org.party_management.service.ContactMechTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rest/contactMechType")
@RequiredArgsConstructor
public class ContactMechTypeController {
    private final ContactMechTypeService contactMechTypeService;

    @GetMapping
    public ApiResponse<List<ContactMechType>> getAllContactMechTypes(){
        List<ContactMechType> response = contactMechTypeService.getAllContactMechTypes();
        return ApiResponse.success(HttpStatus.OK.value(), "", response);
    }
}

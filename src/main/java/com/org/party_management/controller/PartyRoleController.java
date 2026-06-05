package com.org.party_management.controller;

import com.org.party_management.dto.response.ApiResponse;
import com.org.party_management.model.PartyRole;
import com.org.party_management.service.PartyRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rest/partyRole")
@RequiredArgsConstructor
public class PartyRoleController {

    private final PartyRoleService partyRoleService;

    @GetMapping
    public ApiResponse<List<PartyRole>> getAllRoles(){
        List<PartyRole> partyRoleList = partyRoleService.getAllRole();

        return ApiResponse.success(HttpStatus.OK.value(), "",partyRoleList);
    }
}

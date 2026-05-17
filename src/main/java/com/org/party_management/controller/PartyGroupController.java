package com.org.party_management.controller;

import com.org.party_management.dto.request.PartyGroupRequest;
import com.org.party_management.dto.response.ApiResponse;
import com.org.party_management.dto.response.PartyGroupResponse;
import com.org.party_management.dto.response.PartyResponse;
import com.org.party_management.service.PartyGroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest/partyGroup")
@RequiredArgsConstructor
public class PartyGroupController {

    private final PartyGroupService partyGroupService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PartyGroupResponse> createPartyGroup(@Valid @RequestBody PartyGroupRequest request){
        PartyGroupResponse response = partyGroupService.createPartyGroup(request);

        return ApiResponse.success(HttpStatus.CREATED.value(),"Group Created Successfully.",response);
    }

    @GetMapping("/{partyId}")
    public ApiResponse<PartyGroupResponse> getPartyGroupById(@PathVariable Long partyId){
        PartyGroupResponse response = partyGroupService.getPartyGroupById(partyId);
        return ApiResponse.success(HttpStatus.OK.value(), "Party Group Fetched", response);
    }

    @PutMapping("/{partyId}")
    public ApiResponse<PartyGroupResponse> updatePartyGroup(@PathVariable Long partyId ,@Valid @RequestBody PartyGroupRequest request){
        PartyGroupResponse response = partyGroupService.updatePartyGroup(partyId, request);
        return ApiResponse.success(HttpStatus.OK.value(), "Party Group Updated Successfully.", response);
    }

    @GetMapping
    public ApiResponse<List<PartyGroupResponse>> getAllPartyGroup() {

        List<PartyGroupResponse> response =  partyGroupService.getAllPartyGroup();
        return ApiResponse.success(
                HttpStatus.OK.value(),
                "",
                response
        );
    }



}

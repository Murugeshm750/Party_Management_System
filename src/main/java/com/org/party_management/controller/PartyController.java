package com.org.party_management.controller;

import com.org.party_management.dto.response.ApiResponse;
import com.org.party_management.dto.request.PartyRequest;
import com.org.party_management.dto.response.PartyResponse;
import com.org.party_management.service.PartyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/party")
@RequiredArgsConstructor
public class PartyController {

    private final PartyService partyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PartyResponse> createParty(@Valid @RequestBody PartyRequest request) {

        PartyResponse response = partyService.createParty(request);

        return ApiResponse.success(
                HttpStatus.CREATED.value(),
                "Party created successfully",
                response
        );
    }
    @PutMapping("/{partyId}")
    public ApiResponse<PartyResponse> updateParty(@PathVariable Long partyId, @Valid @RequestBody PartyRequest request
    ) {
        PartyResponse response = partyService.updateParty(partyId, request);
        return ApiResponse.success(
                HttpStatus.OK.value(),
                "Party Updated Successfully.",
                response
        );
    }

    @GetMapping("/{partyId}")
    public ApiResponse<PartyResponse> getPartyById(@PathVariable Long partyId){

        PartyResponse response = partyService.getPartyById(partyId);
        return ApiResponse.success(
                HttpStatus.OK.value(),
                "Party fetched successfully",
                response
        );
    }

    @GetMapping
    public ApiResponse<List<PartyResponse>> getAllParties() {

        List<PartyResponse> response =  partyService.getAllParties();
        return ApiResponse.success(
                HttpStatus.OK.value(),
                "",
                response
        );
    }


}

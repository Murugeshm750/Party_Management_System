package com.org.party_management.controller;

import com.org.party_management.dto.request.PaymentCreateRequest;
import com.org.party_management.dto.request.PaymentUpdateRequest;
import com.org.party_management.dto.response.ApiResponse;
import com.org.party_management.dto.response.PaymentResponse;
import com.org.party_management.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.org.party_management.dto.response.ApiResponse.success;

@RestController
@RequestMapping("/api/rest/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PaymentResponse> makePayment(@Valid @RequestBody PaymentCreateRequest request){
        PaymentResponse response = paymentService.createPayment(request);
        return success(HttpStatus.CREATED.value(), "Payment Created Successfully.", response);
    }

    @PatchMapping("/{paymentId}")
    public ApiResponse<PaymentResponse> updatePayment(@PathVariable Long paymentId, @Valid @RequestBody PaymentUpdateRequest request){
        PaymentResponse response = paymentService.updatePayment(paymentId,request);
        return success(HttpStatus.OK.value(), "Payment Updated Successfully",response);
    }

    @GetMapping("/{paymentId}")
    public ApiResponse<PaymentResponse> getPayment(@PathVariable Long paymentId){
        PaymentResponse response = paymentService.getPaymentById(paymentId);
        return success(HttpStatus.OK.value(), "",response);
    }

    @GetMapping("/party{partyId}")
    public ApiResponse<List<PaymentResponse>> getAllPartyPayments(@PathVariable Long partyId){
        List<PaymentResponse> responses = paymentService.getAllPaymentsPartyById(partyId);
        return ApiResponse.success(HttpStatus.OK.value(), "", responses);
    }

}

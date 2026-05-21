package com.org.party_management.service;

import com.org.party_management.dto.request.PaymentCreateRequest;
import com.org.party_management.dto.request.PaymentUpdateRequest;
import com.org.party_management.dto.response.PaymentResponse;
import com.org.party_management.model.PartyPayment;

import java.util.List;

public interface PaymentService {
    PaymentResponse createPayment(PaymentCreateRequest request);
    PaymentResponse updatePayment(Long paymentId, PaymentUpdateRequest request);
    PaymentResponse getPaymentById(Long paymentId);
    List<PaymentResponse> getAllPaymentsPartyById(Long partyId);

}

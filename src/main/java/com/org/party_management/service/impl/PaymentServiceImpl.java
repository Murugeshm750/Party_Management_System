package com.org.party_management.service.impl;

import com.org.party_management.dto.request.PaymentCreateRequest;
import com.org.party_management.dto.request.PaymentUpdateRequest;
import com.org.party_management.dto.response.PaymentResponse;
import com.org.party_management.exception.ResourceNotFoundException;
import com.org.party_management.mapper.PaymentMapper;
import com.org.party_management.model.Party;
import com.org.party_management.model.PartyPayment;
import com.org.party_management.repository.PartyPaymentRepository;
import com.org.party_management.repository.PartyRepository;
import com.org.party_management.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PartyPaymentRepository partyPaymentRepository;
    private final PartyRepository partyRepository;
    private final PaymentMapper paymentMapper;


    @Override
    public PaymentResponse createPayment(PaymentCreateRequest request) {
        Party party = partyRepository.findById(request.getPartyId())
                .orElseThrow(() -> new ResourceNotFoundException("Party Not Found"));

        PartyPayment partyPayment = paymentMapper.createPayment(request);

        // IMPORTANT
        partyPayment.setParty(party);
        PartyPayment savePayment = partyPaymentRepository.save(partyPayment);
        return paymentMapper.paymentResponse(savePayment);
    }

    @Override
    public PaymentResponse updatePayment(Long paymentId, PaymentUpdateRequest request) {
        PartyPayment partyPayment = partyPaymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment Not Found"));

        paymentMapper.updatePayment(partyPayment, request);
        PartyPayment updatePayment = partyPaymentRepository.saveAndFlush(partyPayment);
        return paymentMapper.paymentResponse(updatePayment);
    }

    @Override
    public PaymentResponse getPaymentById(Long paymentId) {
        PartyPayment partyPayment = partyPaymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment NOt Found"));

        return paymentMapper.paymentResponse(partyPayment);
    }

    @Override
    public List<PaymentResponse>
    getAllPaymentsPartyById(Long partyId) {

        return partyPaymentRepository
                .findByPartyPartyId(partyId)
                .stream()
                .map(paymentMapper::paymentResponse)
                .toList();
    }
}

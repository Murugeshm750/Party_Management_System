package com.org.party_management.mapper;

import com.org.party_management.dto.request.PaymentCreateRequest;
import com.org.party_management.dto.request.PaymentUpdateRequest;
import com.org.party_management.dto.response.PaymentResponse;
import com.org.party_management.model.PartyPayment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class PaymentMapper {
    public PartyPayment createPayment(PaymentCreateRequest request){
        return PartyPayment.builder()
                .actualPaidDate(request.getActualPaidDate())
                .amount(request.getAmount())
                .paidDate(LocalDateTime.now())
                .statusId(request.getStatusId())
                .build();
    }

    public PaymentResponse paymentResponse(PartyPayment partyPayment){
        return PaymentResponse.builder()
                .partyId(partyPayment.getParty().getPartyId())
                .paymentId(partyPayment.getPaymentId())
                .paidDate(partyPayment.getPaidDate())
                .actualPaidDate(partyPayment.getActualPaidDate())
                .amount(partyPayment.getAmount())
                .statusId(partyPayment.getStatusId())
                .build();
    }

    public void updatePayment(PartyPayment partyPayment, PaymentUpdateRequest request){
        partyPayment.setAmount(request.getAmount());
        partyPayment.setStatusId(request.getStatusId());
        partyPayment.setActualPaidDate(request.getActualPaidDate());
    }
}

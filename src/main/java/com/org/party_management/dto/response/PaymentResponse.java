package com.org.party_management.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private Long partyId;
    private Long paymentId;
    private String statusId;
    private Long amount;
    private LocalDateTime paidDate;
    private LocalDateTime actualPaidDate;
}

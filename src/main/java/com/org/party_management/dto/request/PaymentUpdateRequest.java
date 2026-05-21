package com.org.party_management.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentUpdateRequest {
    private Long amount;
    private String statusId;
    private LocalDateTime actualPaidDate;
}

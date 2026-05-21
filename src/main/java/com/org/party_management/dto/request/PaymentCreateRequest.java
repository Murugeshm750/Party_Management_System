package com.org.party_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreateRequest {
    @NotNull(message = "Amount can't be null")
    @Positive(message = "Amount must be greater than 0")
    private Long amount;

    @NotNull(message = "Party Id Can't be Empty")
    private Long partyId;

//    private LocalDateTime paidDate;

    private LocalDateTime actualPaidDate;

    @NotBlank(message = "Status Can't be Empty")
    private String statusId;
}

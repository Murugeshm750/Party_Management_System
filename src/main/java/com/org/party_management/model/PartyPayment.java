package com.org.party_management.model;

import com.org.party_management.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "party_payment")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartyPayment extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id")
    private Party party;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(
            name = "payment_seq",
            sequenceName = "payment_sequence",
            initialValue = 10000,
            allocationSize = 1
    )
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "status_id")
    private String statusId;

    @Column(name = "paid_date")
    private LocalDateTime paidDate;

    @Column(name = "actual_paid_date")
    private LocalDateTime actualPaidDate;


}

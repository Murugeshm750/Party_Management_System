package com.org.party_management.model;

import com.org.party_management.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "party")
@Getter
@Setter
@Builder //it is useful for dto mapping and testing
@AllArgsConstructor
@NoArgsConstructor
public class Party extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_seq")
    @SequenceGenerator(
            name = "party_seq",
            sequenceName = "party_sequence",
            initialValue = 10000,
            allocationSize = 1
    )
    @Column(name = "party_id")
    private Long partyId;

    @Column(name = "party_type_id", nullable = false, length = 30)
    private String partyTypeId;

    @Column(name = "preferred_currency_uom_id", length = 10)
    private String preferredCurrencyUomId;

    @Column(length = 255)
    private String description;

    @Column(name = "status_id", nullable = false, length = 20)
    private String statusId;

    @OneToOne(mappedBy = "party")
    private PartyGroup partyGroup;

    @OneToMany(mappedBy = "party")
    private List<PartyPayment> payments;
}
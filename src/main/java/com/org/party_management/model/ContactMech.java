package com.org.party_management.model;

import com.org.party_management.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact_mech")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactMech extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq")
    @SequenceGenerator(
            name = "contact_seq",
            sequenceName = "contact_sequence",
            initialValue = 10000,
            allocationSize = 1
    )
    @Column(name = "contact_mech_id")
    private Long contactMechId;

    @Column(name = "party_id")
    private Long partyId;

    @Column(name = "contact_mech_type_id")
    private String contactMechTypeId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id", insertable = false, updatable = false)
    private Party party;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_mech_type_id", insertable = false, updatable = false)
    private ContactMechType contactMechType;

    @Column(name = "contact_value")
    private String contactValue;

    @Column(name = "expire_date")
    private LocalDateTime expireDate;





}

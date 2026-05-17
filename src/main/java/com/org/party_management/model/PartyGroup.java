package com.org.party_management.model;

import com.org.party_management.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "party_group")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartyGroup extends BaseEntity {

    @Id
    private Long partyId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "party_id")
    private Party party;

    private String groupName;

    private String description;
}

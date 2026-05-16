package com.org.party_management.model;

import com.org.party_management.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "party_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartyType extends BaseEntity {

    @Column(name = "party_type_id")
    @Id
    private String partyTypeId;

    @Column(name = "description")
    private String description;


}

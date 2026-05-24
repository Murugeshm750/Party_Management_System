package com.org.party_management.model;

import com.org.party_management.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "party_role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PartyRole extends BaseEntity {

    @Id
    @Column(name = "role_type_id")
    private String roleTypeId;

    @Column(name = "description")
    private String description;
}

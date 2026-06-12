package com.org.party_management.model;

import com.org.party_management.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "contact_mech_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactMechType extends BaseEntity {

    @Id
    @Column(name = "contact_mech_type_id")
    private String contactMechTypeId;

    private String description;

    @OneToMany(mappedBy = "contactMechType")
    private List<ContactMech> contactMechList;
}

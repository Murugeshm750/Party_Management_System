package com.org.party_management.model;

import com.org.party_management.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.UUID;

@Entity
@Table(name = "user_login")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin extends BaseEntity {

    @Id
    private Long partyId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "party_id")
    private Party party;

    @Column(name = "user_login_id", unique = true)
    @NonNull
    private String userLoginId;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;


}

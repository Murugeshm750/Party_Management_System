package com.org.party_management.model;

import com.org.party_management.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "user_login")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "password")       // ✅ never print password in logs
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

    @Column(name = "role_type_id", nullable = false, length = 30)
    private String roleTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "role_type_id",
            referencedColumnName = "role_type_id",
            insertable = false,
            updatable = false
    )
    private PartyRole partyRole;
}

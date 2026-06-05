package com.org.party_management.dto.response;

import com.org.party_management.repository.UserLoginRepository;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginResponse {
    private Long partyId;
    private String userLoginId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role;
    private Long partyGroupId;
    private String partyGroupName;
}

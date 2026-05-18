package com.org.party_management.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginPatchRequest {

    private String userName;

    private String firstName;

    private String middleName;

    private String lastName;
}
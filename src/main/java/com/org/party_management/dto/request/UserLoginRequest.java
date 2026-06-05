package com.org.party_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    @NotBlank(message = "User Name Can't be Empty")
    private String userName;
    @NotBlank(message = "Password Can't be Empty")
    private String password;
    @NotBlank(message = "First Name Can't be Empty")
    private String firstName;
    private String middleName;
    @NotBlank(message = "Last Name Can't be Empty")
    private String lastName;
    @NotBlank(message = "Role Can't be Empty")
    private String roleTypeId;
    @NotNull(message = "Party Group Can't be Empty")
    private Long partyId;


}

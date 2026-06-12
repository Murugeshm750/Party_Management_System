package com.org.party_management.dataSeed;

import com.org.party_management.dto.request.UserLoginRequest;
import com.org.party_management.model.ContactMech;
import com.org.party_management.model.ContactMechType;
import com.org.party_management.model.PartyRole;
import com.org.party_management.model.PartyType;
import com.org.party_management.repository.ContactMechTypeRepository;
import com.org.party_management.repository.PartyRoleRepository;
import com.org.party_management.repository.PartyTypeRepository;
import com.org.party_management.repository.UserLoginRepository;
import com.org.party_management.service.UserLoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Order(1)
public class DataSeeder implements CommandLineRunner {


   private final PartyTypeRepository partyTypeRepository;
   private final PartyRoleRepository partyRoleRepository;
   private final UserLoginRepository userLoginRepository;
   private final UserLoginService userLoginService;
   private final ContactMechTypeRepository contactMechTypeRepository;


    @Override
    public void run(String... args) throws Exception {
        seedPartyTypeData();
        seedPartyRoleData();
        seedAdminUser();
        seedContactMechTypeData();

    }

    private void seedPartyTypeData(){
        validatePartyTypeData("PARTY_GROUP", "Party Group");
        validatePartyTypeData("PARTY_PERSON", "Party Person");

    }

    private void validatePartyTypeData(String partyTypeId, String description){
        boolean exists = partyTypeRepository.existsById(partyTypeId);

        if (!exists) {
            PartyType partyType = PartyType.builder()
                    .partyTypeId(partyTypeId)
                    .description(description)
                    .build();

            partyTypeRepository.save(partyType);
        }
    }

    private void seedPartyRoleData(){
        validatePartyRoleData("USER", "Party User");
        validatePartyRoleData("ADMIN", "Party Admin");
        validatePartyRoleData("ACCOUNTANT", "Party Accountant");

    }

    private void validatePartyRoleData(String roleTypeId, String description){
        boolean exists = partyRoleRepository.existsById(roleTypeId);

        if (!exists) {
            PartyRole partyRole = PartyRole.builder()
                    .roleTypeId(roleTypeId)
                    .description(description)
                    .build();

            partyRoleRepository.save(partyRole);
        }
    }

    public void seedAdminUser(){
        UserLoginRequest request = new UserLoginRequest();
        request.setUserName("Admin");
        request.setPassword("Admin");
        request.setFirstName("Admin");
        request.setMiddleName("");
        request.setLastName("User");
        request.setRoleTypeId("ADMIN");
        validateAdminUser(request);

    }

//    private void validateAdminUser(String userLoginId, String password, String firstName, String middleName, String lastName, String roleTypeId){
    private void validateAdminUser(UserLoginRequest request){
        boolean exists = userLoginRepository.existsUserLoginByUserLoginIdEquals(request.getUserName());

        if (!exists){
            userLoginService.createUser(request);
        }
    }


    private void seedContactMechTypeData(){
        validateContactMechTypeData("EMAIL_ADDRESS", "Email Address");
        validateContactMechTypeData("MOBILE_NUMBER", "Mobile Number");
        validateContactMechTypeData("POSTAL_ADDRESS", "Postal Address");
    }

    private void validateContactMechTypeData(String contactMechTypeId, String description){
        boolean exists = contactMechTypeRepository.existsById(contactMechTypeId);

        if (!exists) {
            ContactMechType contactMechType = ContactMechType.builder()
                    .contactMechTypeId(contactMechTypeId)
                    .description(description)
                    .build();

            contactMechTypeRepository.save(contactMechType);
        }
    }



}

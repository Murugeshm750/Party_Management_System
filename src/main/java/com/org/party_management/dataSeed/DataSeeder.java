package com.org.party_management.dataSeed;

import com.org.party_management.model.PartyType;
import com.org.party_management.repository.PartyTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Order(1)
public class DataSeeder implements CommandLineRunner {


   private final PartyTypeRepository partyTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        seedPartyTypeData();

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




}

package com.org.party_management.repository;

import com.org.party_management.model.PartyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyTypeRepository extends JpaRepository<PartyType, String> {
}

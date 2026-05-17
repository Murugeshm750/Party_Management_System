package com.org.party_management.repository;

import com.org.party_management.model.PartyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyGroupRepository extends JpaRepository<PartyGroup, Long> {
}

package com.org.party_management.repository;

import com.org.party_management.model.PartyRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRoleRepository extends JpaRepository<PartyRole, String> {
}

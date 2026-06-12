package com.org.party_management.repository;

import com.org.party_management.model.ContactMechType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMechTypeRepository extends JpaRepository<ContactMechType, String> {
}

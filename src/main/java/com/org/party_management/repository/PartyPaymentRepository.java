package com.org.party_management.repository;

import com.org.party_management.model.PartyPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyPaymentRepository extends JpaRepository<PartyPayment, Long> {
    List<PartyPayment> findByPartyPartyId(Long partyId);
}

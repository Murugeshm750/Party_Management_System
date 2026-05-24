package com.org.party_management.repository;

import com.org.party_management.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    Optional<UserLogin> findByUserLoginId(String userLoginId);
    boolean existsUserLoginByUserLoginIdEquals(String userLoginId);
}

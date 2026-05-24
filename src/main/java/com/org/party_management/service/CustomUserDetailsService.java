package com.org.party_management.service;

import com.org.party_management.model.UserLogin;
import com.org.party_management.repository.UserLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String userLoginId) throws UsernameNotFoundException {

        UserLogin user = userLoginRepository.findByUserLoginId(userLoginId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(user.getUserLoginId(), user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRoleTypeId()))
        );
    }
}
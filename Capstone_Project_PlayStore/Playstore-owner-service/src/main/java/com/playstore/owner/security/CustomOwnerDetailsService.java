package com.playstore.owner.security;

import com.playstore.owner.repository.OwnerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomOwnerDetailsService implements UserDetailsService {

    private final OwnerRepository repo;

    public CustomOwnerDetailsService(OwnerRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.playstore.owner.model.Owner o = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Owner not found"));

        return User.withUsername(o.getEmail())
                .password(o.getPassword())
                .roles("OWNER")
                .build();
    }
}

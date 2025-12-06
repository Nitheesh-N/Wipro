package com.playstore.owner.service;

import com.playstore.owner.model.App;
import com.playstore.owner.model.Owner;
import com.playstore.owner.repository.AppRepository;
import com.playstore.owner.repository.OwnerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OwnerService {

    private final OwnerRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final AppRepository appRepository;

    public OwnerService(OwnerRepository repo, PasswordEncoder passwordEncoder, AppRepository appRepository) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
        this.appRepository = appRepository;
    }

    public Owner register(Owner owner) {
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        return repo.save(owner);
    }

    public Owner loginRaw(String email, String rawPassword) {
        return repo.findByEmail(email)
                .filter(o -> passwordEncoder.matches(rawPassword, o.getPassword()))
                .orElse(null);
    }
    public App saveApp(App app) {
        return appRepository.save(app);
    }
    
    public Owner findByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }


    public List<Owner> getAllOwners() {
        return repo.findAll();
    }

}

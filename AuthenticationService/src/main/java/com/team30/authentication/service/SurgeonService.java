package com.team30.authentication.service;

import com.team30.authentication.entity.Surgeon;
import com.team30.authentication.exception.DuplicateEntryException;
import com.team30.authentication.repository.SurgeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeonService implements UserDetailsService {
    @Autowired
    private SurgeonRepository surgeonRepository;
    public Surgeon register(Surgeon surgeon){
        if(surgeonRepository.existsByEmail(surgeon.getEmail())) throw new DuplicateEntryException("Duplicate email : "+surgeon.getEmail());

        return surgeonRepository.save(surgeon);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Surgeon surgeon = surgeonRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found"));
        return surgeon;
    }

    public List<Surgeon> getSurgeons() {
        return surgeonRepository.findAll();
    }
}

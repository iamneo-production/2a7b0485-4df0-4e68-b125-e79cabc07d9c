package com.team30.authentication.repository;

import com.team30.authentication.entity.Surgeon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurgeonRepository extends JpaRepository<Surgeon,Long> {

    Optional<Surgeon> findByEmail(String email);

    boolean existsByEmail(String email);
}

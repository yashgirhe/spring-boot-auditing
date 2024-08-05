package com.example.spring_boot_auditing.spring_boot_auditing.repositories;

import com.example.spring_boot_auditing.spring_boot_auditing.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
package com.example.spring_boot_auditing.spring_boot_auditing.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    //get user from spring security
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Yash Girhe");
    }
}

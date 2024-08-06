package com.example.spring_boot_auditing.spring_boot_auditing.services;

import com.example.spring_boot_auditing.spring_boot_auditing.dto.SignUpDto;
import com.example.spring_boot_auditing.spring_boot_auditing.dto.UserDto;
import com.example.spring_boot_auditing.spring_boot_auditing.entities.User;
import com.example.spring_boot_auditing.spring_boot_auditing.exceptions.ResourceNotFoundException;
import com.example.spring_boot_auditing.spring_boot_auditing.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new BadCredentialsException("User with email " + username + " not found"));
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
    }

    public UserDto signUp(SignUpDto signUpDto) {
        Optional<User> user = userRepository.findByEmail(signUpDto.getEmail());
        if (user.isPresent()) {
            throw new BadCredentialsException("User with email already exist: " + signUpDto.getEmail());
        }
        User toBeCreateUser = modelMapper.map(signUpDto, User.class);
        toBeCreateUser.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        User savedUser = userRepository.save(toBeCreateUser);
        return modelMapper.map(savedUser, UserDto.class);
    }
}
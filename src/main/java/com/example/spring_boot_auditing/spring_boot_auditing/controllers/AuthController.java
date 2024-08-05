package com.example.spring_boot_auditing.spring_boot_auditing.controllers;

import com.example.spring_boot_auditing.spring_boot_auditing.dto.LoginDto;
import com.example.spring_boot_auditing.spring_boot_auditing.dto.SignUpDto;
import com.example.spring_boot_auditing.spring_boot_auditing.dto.UserDto;
import com.example.spring_boot_auditing.spring_boot_auditing.services.AuthService;
import com.example.spring_boot_auditing.spring_boot_auditing.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto) {
        UserDto userDto = userService.signUp(signUpDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        String token = authService.login(loginDto);
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }
}
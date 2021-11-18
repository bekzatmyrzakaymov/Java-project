package com.spring.project;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String plainPassword = "mike2020";
        String encodedPassword = passwordEncoder.encode(plainPassword);

        System.out.println(encodedPassword);
    }
}

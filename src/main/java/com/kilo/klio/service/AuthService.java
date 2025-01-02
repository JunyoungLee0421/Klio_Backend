package com.kilo.klio.service;

import com.kilo.klio.entity.User;
import com.kilo.klio.repository.userRepository;
import com.kilo.klio.Security.JwtUtils;
import com.kilo.klio.Security.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.math.BigDecimal;
import java.util.Map;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public ResponseEntity<?> registerUser(String firstName, String lastName, String email, String rawPassword, BigDecimal budget) {

        if (userRepository.existsByEmail(email)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "status", "fail",
                        "message", "Email is already in use",
                        "errorCode", "EMAIL_ALREADY_EXISTS"
                ));
        }

        List<String> validationError = PasswordValidator.validatePassword(rawPassword);
        if (!validationError.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                    "status", "fail",
                    "message", validationError,
                    "errorCode", "INVALID_PASSWORD"
                ));
        }

        try {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(rawPassword));
            user.setBudget(budget);

            userRepository.save(user);

            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "User registered successfully"
            ));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                    "status", "fail",
                    "message", "Error registering user",
                    "errorCode", "INTERNAL_SERVER_ERROR"
                ));
        }
    }

    public ResponseEntity<?> loginUser(String email, String rawPassword) {
    
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
            "status", "fail",
            "message", "User not found!"
        ));
        }

        User user = optionalUser.get();

        // Check password
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
            "status", "fail",
            "message", "Invalid password!"
        ));
        }

        // Generate JWT token
        String token = jwtUtils.generateToken(email);

        // Return token
        return ResponseEntity.ok(Map.of(
        "status", "success",
        "message", "Login successful",
        "token", token
    ));
    }
}

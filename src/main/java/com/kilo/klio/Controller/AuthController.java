package com.kilo.klio.Controller;

import com.kilo.klio.service.AuthService;
import com.kilo.klio.Payload.LoginRequest;
import com.kilo.klio.Payload.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        return authService.registerUser(
                signupRequest.getFname(),
                signupRequest.getLname(),
                signupRequest.getEmail(),
                signupRequest.getPassword(),
                signupRequest.getBudget()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(
            loginRequest.getEmail(),
            loginRequest.getPassword()
        );
    }
}

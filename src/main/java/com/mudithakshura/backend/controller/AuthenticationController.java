package com.mudithakshura.backend.controller;

import com.mudithakshura.backend.dto.JwtAuthenticationResponse;
import com.mudithakshura.backend.dto.RefreshTokenRequest;
import com.mudithakshura.backend.dto.SignUpRequest;
import com.mudithakshura.backend.dto.SigninRequest;
import com.mudithakshura.backend.model.User;
import com.mudithakshura.backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth") // can be like this ("/api/v1/auth") See SecurityConfig.securityFilterChain
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

}

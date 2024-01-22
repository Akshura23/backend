package com.mudithakshura.backend.service;

import com.mudithakshura.backend.dto.JwtAuthenticationResponse;
import com.mudithakshura.backend.dto.RefreshTokenRequest;
import com.mudithakshura.backend.dto.SignUpRequest;
import com.mudithakshura.backend.dto.SigninRequest;
import com.mudithakshura.backend.model.User;

public interface AuthenticationService {
    public User signup(SignUpRequest signUpRequest);

    public JwtAuthenticationResponse signin(SigninRequest signinRequest);

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

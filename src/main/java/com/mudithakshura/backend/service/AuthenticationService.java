package com.mudithakshura.backend.service;

import com.mudithakshura.backend.dto.JwtAuthenticationResponse;
import com.mudithakshura.backend.dto.RefreshTokenRequest;
import com.mudithakshura.backend.dto.SignUpRequest;
import com.mudithakshura.backend.dto.SigninRequest;
import com.mudithakshura.backend.model.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

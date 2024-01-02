package com.mudithakshura.backend.service.impl;

import com.mudithakshura.backend.dto.SignUpRequest;
import com.mudithakshura.backend.model.Role;
import com.mudithakshura.backend.model.User;
import com.mudithakshura.backend.repository.UserRepostitory;
import com.mudithakshura.backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepostitory userRepostitory;

    private final PasswordEncoder passwordEncoder;

    public User signup(SignUpRequest signUpRequest){

        User user = new User();

        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstName());
        user.setLastname(signUpRequest.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepostitory.save(user);
    }
}

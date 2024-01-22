package com.mudithakshura.backend.service.impl;

import com.mudithakshura.backend.model.User;
import com.mudithakshura.backend.repository.UserRepostitory;
import com.mudithakshura.backend.service.JWTService;
import com.mudithakshura.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepostitory userRepostitory;

    private final JWTService jwtService;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepostitory.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public User findUserByJwt(String jwt) {
        String email = jwtService.extractUserName(jwt);

        return userRepostitory.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
    }

}

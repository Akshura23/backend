package com.mudithakshura.backend.service;

import com.mudithakshura.backend.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    public UserDetailsService userDetailsService();

    public User findUserByJwt(String jwt);
}

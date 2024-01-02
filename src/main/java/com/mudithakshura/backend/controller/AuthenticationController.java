package com.mudithakshura.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth") // can be like this ("/api/v1/auth") See SecurityConfig.securityFilterChain
@RequiredArgsConstructor
public class AuthenticationController {
}

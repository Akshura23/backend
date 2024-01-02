package com.mudithakshura.backend.repository;

import com.mudithakshura.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepostitory extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}

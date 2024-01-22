package com.mudithakshura.backend.repository;

import com.mudithakshura.backend.model.Role;
import com.mudithakshura.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepostitory extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);
    public User findUserById(Integer id);

    public User findByRole(Role role);
}

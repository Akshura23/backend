package com.mudithakshura.backend.repository;

import com.mudithakshura.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostitory extends JpaRepository<User,Long> {
}

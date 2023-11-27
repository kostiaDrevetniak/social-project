package com.social.project.demo.repository;

import com.social.project.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Transactional
    User findByUsername(String username);
}

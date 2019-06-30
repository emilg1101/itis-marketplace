package com.github.emilg1101.marketplace.data.repository;

import com.github.emilg1101.marketplace.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

package com.pramodvaddiraju.jobpulse.repository;

import com.pramodvaddiraju.jobpulse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom method to find a user by email
    Optional<User> findByEmail(String email);
}

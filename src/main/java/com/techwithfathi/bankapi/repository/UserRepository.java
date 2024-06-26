package com.techwithfathi.bankapi.repository;

import com.techwithfathi.bankapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    List<User> findByUsernameIn(List<String> usernames);
}

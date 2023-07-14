package org.springframework.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);
}

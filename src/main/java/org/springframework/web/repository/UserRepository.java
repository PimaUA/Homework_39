package org.springframework.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}

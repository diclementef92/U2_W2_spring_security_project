package com.spring_security_project.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_security_project.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUserName(String username);

	Optional<User> findByEmail(String email);

	Optional<User> findByUserNameOrEmail(String username, String email);

	Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);
}

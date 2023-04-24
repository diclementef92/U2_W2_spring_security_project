package com.spring_security_project.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security_project.auth.entity.User;
import com.spring_security_project.auth.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
    
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	public User insertUser(User d) {
		return repo.save(d);
	}

	public User updateUser(User d) {
		return repo.save(d);
	}

	public void removeUser(User d) {
		repo.deleteById(d.getId());
	}

	public Optional<User> findByUserName(String username) {
		return repo.findByUserName(username);
	}
	public Optional<User> findByEmail (String email) {
		return repo.findByEmail(email);
	}

	public Optional<User> findByUserNameOrEmail(String username, String email) {
		return repo.findByUserNameOrEmail(username, email);
	}

	public Boolean existsByUserName(String username) {
		return repo.existsByUserName(username);
	}

	public Boolean existsByEmail(String email) {
		return repo.existsByEmail(email);
	}
}

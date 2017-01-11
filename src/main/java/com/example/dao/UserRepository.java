package com.example.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Collection<User> findByUserName(String userName);

	Collection<User> findByRole(String role);
}

package com.example.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Person;
import com.example.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

	Collection<Person> findByUserName(String userName);

	Collection<Person> findByRole(String role);
}

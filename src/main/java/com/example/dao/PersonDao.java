package com.example.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Person;

public interface PersonDao extends JpaRepository<Person, Long> {

	Collection<Person> findByName(String name);

	Collection<Person> findById(Long id);
}

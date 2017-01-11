package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.example.dao.PersonRepository;

@SpringBootApplication
@EnableCaching
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Autowired
	private PersonRepository personDao;

	@Bean
	CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				personDao.findAll().forEach(System.out::println);
			}
		};
	}
}

package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.example.dao.PersonDao;

@SpringBootApplication
@EnableCaching
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Autowired
	private PersonDao personDao;

	@Bean
	CommandLineRunner runner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				// storeSpampleData();
				personDao.findAll().forEach(System.out::println);
			}

			// private void storeSpampleData() {
			// List<String> names =
			// Arrays.asList("Peter,John,Tobias,Lisa".split(","));
			// for (String name : names) {
			// personDao.save(new Person(name));
			// }
			// }
		};
	}
}

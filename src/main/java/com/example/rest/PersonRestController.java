package com.example.rest;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PersonDao;
import com.example.entity.Person;

@RestController
public class PersonRestController {

	@Autowired
	private PersonDao personDao;

	AtomicInteger counter = new AtomicInteger();

	@RequestMapping("/person")
	public Collection<Person> personByNane(@RequestParam Map<String, String> requestParams) {
		String id = requestParams.get("id");
		String name = requestParams.get("name");

		if (requestParams.isEmpty()) {
			return personDao.findAll();
		}
		if (StringUtils.isNotEmpty(id)) {
			return personDao.findById(Long.valueOf(id));
		}
		if (StringUtils.isNotEmpty(name)) {
			return personDao.findByName(name);
		}
		return null;
	}
}

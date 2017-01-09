package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.dao.UserDao;
import com.example.entity.User;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDao userDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		@formatter:off
        http.authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .antMatchers("/person").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
      
        .logout()
            .permitAll();
//		@formatter:on
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		User user = userDao.findAll().get(0);
		if (user != null)
			auth.inMemoryAuthentication().withUser(user.getUserName()).password(user.getPassword())
					.roles(user.getRole());
		else
			auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");

	}
}
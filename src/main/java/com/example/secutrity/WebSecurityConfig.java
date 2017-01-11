package com.example.secutrity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.dao.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository userDao;

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
	public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService)
			throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new CustomPasswordEncoder());
		// User user = userDao.findAll().get(0);
		// if (user != null)
		// auth.inMemoryAuthentication().withUser(user.getUserName()).password(user.getPassword())
		// .roles(user.getRole());
		// else
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

}
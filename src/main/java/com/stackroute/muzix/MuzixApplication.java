package com.stackroute.muzix;

import com.stackroute.muzix.exceptions.UserAlreadyExistsException;
import com.stackroute.muzix.model.User;
import com.stackroute.muzix.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MuzixApplication {
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}
	@Override
 	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MuzixApplication.class);
	}

	public MuzixApplication(UserService userService) {
		this.userService = userService;
	}
	@Override
	public void run(String[] args) {
		try {
			userService.saveUser(new User(1, "All of me", "john wick",23));
			userService.saveUser(new User(2, "Crazy in love", "50 shades",22));
		} catch (UserAlreadyExistsException e) {
			e.printStackTrace();
		}
	}
}

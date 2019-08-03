package com.stackroute.muzix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//SpringBootApplication annotation can be used to enable those three features, that is:
//@EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
//@ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
//@Configuration: allow to register extra beans in the context or import additional configuration classes
public class MuzixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}

}

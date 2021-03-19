package dev.wan.SpringBookAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// this tells Spring to check all packages for components
@ComponentScan(basePackages = {"dev.wan"})
// This tells Spring DATA where your repos are
@EnableJpaRepositories(basePackages = {"dev.wan.repos"})
// This will tell Spring DATA where to find your entities
@EntityScan(basePackages = {"dev.wan.entities"})
// This annotation is very important
// denotes this is main file and is a spring boot application
@SpringBootApplication
public class SpringBookApiApplication {


	public static void main(String[] args) {
		// Spring Boot is creating an application context for us
		// and some helpful beans
		SpringApplication.run(SpringBookApiApplication.class, args);
	}

}

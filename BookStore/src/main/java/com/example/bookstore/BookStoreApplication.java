package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.delivery.request"})
@EntityScan("com.delivery.domain")
@EnableJpaRepositories("com.delivery.repository")

public class BookStoreApplication extends SpringBootServletInitializer{
	
//	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(BookStoreApplication.class);
//    }
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}

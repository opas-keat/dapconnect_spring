package com.praxis.dapconnect;

import com.github.javafaker.Faker;
import com.praxis.dapconnect.domain.model.entity.Department;
import com.praxis.dapconnect.domain.model.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DapconnectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DapconnectApplication.class, args);
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }

/*
	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("EIS API")
						.description("Employee Information System sample application")
						.version("v0.0.1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org"))
						.description("SpringShop Wiki Documentation")
						.contact(new Contact().email("test@test.com").url("http://fullstackcode.dev")))
				;
	}
*/
}

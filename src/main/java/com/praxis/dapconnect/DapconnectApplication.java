package com.praxis.dapconnect;

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
	public CommandLineRunner demo(DepartmentRepository departmentRepository) {
		return (args) -> {
			Department dep1 = new Department();
			Department dep2 = new Department();

			dep1.setName("dep1");
			dep1.setCreatedBy("admin");

			dep2.setName("dep2");
			dep2.setCreatedBy("admin");

			departmentRepository.saveAll(Arrays.asList(dep1, dep2));

			departmentRepository.findAll().forEach(System.out::println);

		};
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

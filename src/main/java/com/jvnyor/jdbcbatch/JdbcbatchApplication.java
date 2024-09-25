package com.jvnyor.jdbcbatch;

import com.jvnyor.jdbcbatch.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JdbcbatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcbatchApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerService customerService) {
		return args -> {
			customerService.deleteAllJDBC();
			final List<com.jvnyor.jdbcbatch.models.jdbc.Customer> customers = List.of(
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("John", "Doe", "john.doe@mail.com"),
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("Jane", "Smith", "jane.smith@mail.com"),
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("Michael", "Johnson", "michael.johnson@mail.com"),
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("Emily", "Davis", "emily.davis@mail.com"),
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("David", "Wilson", "david.wilson@mail.com"),
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("Sophia", "Brown", "sophia.brown@mail.com"),
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("James", "Jones", "james.jones@mail.com"),
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("Olivia", "Garcia", "olivia.garcia@mail.com"),
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("Daniel", "Martinez", "daniel.martinez@mail.com"),
					new com.jvnyor.jdbcbatch.models.jdbc.Customer("Ava", "Hernandez", "ava.hernandez@mail.com")
			);
			customerService.createAllJDBC(customers);
			customerService.deleteAllJDBC();
			customerService.createAllJPA(customers.stream().map(customer -> customer.toEntity(customer.firstName(), customer.lastName(), customer.email())).toList());
		};
	}
}

package com.jvnyor.jdbcbatch;

import org.springframework.boot.SpringApplication;

public class TestJdbcbatchApplication {

	public static void main(String[] args) {
		SpringApplication.from(JdbcbatchApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

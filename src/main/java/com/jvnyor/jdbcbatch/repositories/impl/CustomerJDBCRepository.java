package com.jvnyor.jdbcbatch.repositories.impl;

import com.jvnyor.jdbcbatch.repositories.CustomerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public class CustomerJDBCRepository implements CustomerRepository {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CustomerJDBCRepository.class);

    private static final String INSERT_SQL = "INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public CustomerJDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public void createAll(Collection<com.jvnyor.jdbcbatch.models.jdbc.Customer> customers) {
        log.info("Creating customers in JdbcTemplate batch");
        jdbcTemplate.batchUpdate(INSERT_SQL, customers, customers.size(), (ps, customer) -> {
            ps.setString(1, customer.firstName());
            ps.setString(2, customer.lastName());
            ps.setString(3, customer.email());
        });
        log.info("Created customers in JdbcTemplate batch");
    }

    @Override
    public void deleteAll() {
        log.info("Deleting all customers in JdbcTemplate batch");
        jdbcTemplate.batchUpdate("DELETE FROM customer");
        log.info("Deleted all customers in JdbcTemplate batch");
    }
}

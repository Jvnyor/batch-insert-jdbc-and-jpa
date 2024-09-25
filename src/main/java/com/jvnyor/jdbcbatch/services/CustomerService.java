package com.jvnyor.jdbcbatch.services;

import com.jvnyor.jdbcbatch.models.jpa.Customer;
import com.jvnyor.jdbcbatch.repositories.CustomerRepository;
import com.jvnyor.jdbcbatch.repositories.impl.CustomerJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    private final CustomerJPARepository customerJPARepository;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerJPARepository customerJPARepository) {
        this.customerRepository = customerRepository;
        this.customerJPARepository = customerJPARepository;
    }

    @Transactional
    public void createAllJDBC(List<com.jvnyor.jdbcbatch.models.jdbc.Customer> customers) {
        long currentTimeMillisAtStart = System.currentTimeMillis();
        customerRepository.createAll(customers);
        log.info("Time taken creating all customers with JDBC: {} ms", System.currentTimeMillis() - currentTimeMillisAtStart);
    }

    @Transactional
    public void deleteAllJDBC() {
        long currentTimeMillisAtStart = System.currentTimeMillis();
        customerRepository.deleteAll();
        log.info("Time taken deleting all customers with JDBC: {} ms", System.currentTimeMillis() - currentTimeMillisAtStart);
    }

    @Transactional
    public void createAllJPA(List<Customer> customers) {
        long currentTimeMillisAtStart = System.currentTimeMillis();
        customerJPARepository.saveAll(customers);
        log.info("Time taken creating all customers with JPA: {} ms", System.currentTimeMillis() - currentTimeMillisAtStart);
    }
}

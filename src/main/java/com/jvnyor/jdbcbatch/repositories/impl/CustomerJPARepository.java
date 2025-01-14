package com.jvnyor.jdbcbatch.repositories.impl;

import com.jvnyor.jdbcbatch.models.jpa.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJPARepository extends JpaRepository<Customer, Long> {
}

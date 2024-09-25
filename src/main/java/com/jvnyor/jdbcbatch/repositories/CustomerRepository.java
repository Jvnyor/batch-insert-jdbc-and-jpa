package com.jvnyor.jdbcbatch.repositories;

import java.util.Collection;

public interface CustomerRepository {

    void createAll(Collection<com.jvnyor.jdbcbatch.models.jdbc.Customer> customers);

    void deleteAll();
}

package com.jvnyor.jdbcbatch.models.jdbc;

public record Customer(
        Long id,
        String firstName,
        String lastName,
        String email
) {

    public Customer(String firstName, String lastName, String email) {
        this(null, firstName, lastName, email);
    }

    public com.jvnyor.jdbcbatch.models.jpa.Customer toEntity(String firstName, String lastName, String email) {
        return new com.jvnyor.jdbcbatch.models.jpa.Customer(firstName, lastName, email);
    }
}

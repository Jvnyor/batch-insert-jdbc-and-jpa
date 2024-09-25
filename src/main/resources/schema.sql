CREATE SEQUENCE IF NOT EXISTS customer_id_seq;

CREATE TABLE IF NOT EXISTS customer (
                                        id BIGINT PRIMARY KEY DEFAULT nextval('customer_id_seq'),
                                        first_name VARCHAR(255) NOT NULL,
                                        last_name VARCHAR(255) NOT NULL,
                                        email VARCHAR(255) NOT NULL UNIQUE
);

ALTER SEQUENCE customer_id_seq OWNED BY customer.id;
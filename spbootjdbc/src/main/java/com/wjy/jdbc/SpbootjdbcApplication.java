package com.wjy.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpbootjdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbootjdbcApplication.class, args);
    }

}


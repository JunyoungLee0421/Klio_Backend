package com.kilo.klio.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class PostgreSQLConnection implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String url = System.getenv("DB_URL");
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database Connected!");
        } catch (Exception e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
        }
    }
}

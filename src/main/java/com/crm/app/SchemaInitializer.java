package com.crm.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.crm.config.DatabaseConfig;
import com.crm.setup.SchemaSetup;

public class SchemaInitializer {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD)) {
            if (conn != null) {
                System.out.println("Connected to the database!");
                
                SchemaSetup setup = new SchemaSetup();
                setup.createAllTables(conn);

                System.out.println("\nSchema creation process finished.");
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}
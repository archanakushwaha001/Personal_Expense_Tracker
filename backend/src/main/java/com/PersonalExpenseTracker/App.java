package com.PersonalExpenseTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class App {

    // Define database connection parameters
    static final String DB_URL = "jdbc:mysql://localhost:3306/expense_tracker";
    static final String USER = "root";
    static final String PASS = "Coder@1122";
    static final String QUERY = "SELECT id, first_name, last_name FROM employees";

    public static void main(String[] args) {
        // Use try-with-resources to ensure resources are closed automatically
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            System.out.println("Connection successful!");

            // Process the result set
            while (rs.next()) {
                // Retrieve data by column name or index
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                // Print the results
                System.out.println("ID: " + id + ", Name: " + firstName + " " + lastName);
            }
        } catch (SQLException e) {
            System.err.println("Database connection or query failed: ");
            e.printStackTrace();
        }
    }
}


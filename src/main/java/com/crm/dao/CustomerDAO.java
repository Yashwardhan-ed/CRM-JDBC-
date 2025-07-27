package com.crm.dao;

import com.crm.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void addCustomer(Connection conn, Customer customer) throws SQLException {
        String sql = "INSERT INTO Customer (CompanyName, Industry, Location, Email, Phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getCompanyName());
            pstmt.setString(2, customer.getIndustry());
            pstmt.setString(3, customer.getLocation());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getPhone());
            pstmt.executeUpdate();
        }
    }

    public Customer getCustomerById(Connection conn, int customerId) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE CustomerID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("CompanyName"),
                        rs.getString("Industry"),
                        rs.getString("Location"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getTimestamp("CreatedAt").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers(Connection conn) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                 customers.add(new Customer(
                    rs.getInt("CustomerID"),
                    rs.getString("CompanyName"),
                    rs.getString("Industry"),
                    rs.getString("Location"),
                    rs.getString("Email"),
                    rs.getString("Phone"),
                    rs.getTimestamp("CreatedAt").toLocalDateTime()
                ));
            }
        }
        return customers;
    }
}
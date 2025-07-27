package com.crm.dao;

import com.crm.model.Contact;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public void addContact(Connection conn, Contact contact) throws SQLException {
        String sql = "INSERT INTO Contact (FirstName, LastName, Email, Phone, Position, CustomerID) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact.getFirstName());
            pstmt.setString(2, contact.getLastName());
            pstmt.setString(3, contact.getEmail());
            pstmt.setString(4, contact.getPhone());
            pstmt.setString(5, contact.getPosition());
            pstmt.setInt(6, contact.getCustomerId());
            pstmt.executeUpdate();
        }
    }

    public Contact getContactById(Connection conn, int contactId) throws SQLException {
        String sql = "SELECT * FROM Contact WHERE ContactID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, contactId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Contact(
                        rs.getInt("ContactID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Position"),
                        rs.getInt("CustomerID")
                    );
                }
            }
        }
        return null;
    }
    
    public List<Contact> getAllContacts(Connection conn) throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM Contact";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                contacts.add(new Contact(
                    rs.getInt("ContactID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Email"),
                    rs.getString("Phone"),
                    rs.getString("Position"),
                    rs.getInt("CustomerID")
                ));
            }
        }
        return contacts;
    }
}
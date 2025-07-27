package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crm.model.Lead;

public class LeadDAO {
    public void addLead(Connection conn, Lead lead){
        String sql = "INSERT INTO Leads (FirstName, LastName, Email, Phone, Company) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, lead.getFirstName());
            pstmt.setString(2, lead.getLastName());
            pstmt.setString(3, lead.getEmail());
            pstmt.setString(4, lead.getPhone());
            pstmt.setString(5, lead.getCompany());
            pstmt.setString(6, lead.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public Lead getLead(Connection conn, Lead lead){
        String sql = "SELECT * FROM Leads WHERE leadId = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){
                    return new Lead(
                        rs.getInt("LeadID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Phone"),
                        rs.getString("Company"),
                        rs.getString("Status"),
                        rs.getTimestamp("CreatedAt").toLocalDateTime()
                    );
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Lead> getAllLeads(Connection conn){
        List<Lead> leads = new ArrayList<>();
        String sql = "SELECT * FROM Lead";

        try(Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Lead lead = new Lead(
                    rs.getInt("leadId"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("company"),
                    rs.getString("status"),
                    rs.getTimestamp("createdAt").toLocalDateTime()
                );
                leads.add(lead);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return leads;
    }
}

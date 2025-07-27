package com.crm.dao;

import com.crm.model.Opportunity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OpportunityDAO {

    public void addOpportunity(Connection conn, Opportunity opp) throws SQLException {
        String sql = "INSERT INTO Opportunity (CustomerID, Stage, Value, ExpectedCloseDate, OwnerID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, opp.getCustomerId());
            pstmt.setString(2, opp.getStage());
            pstmt.setBigDecimal(3, opp.getValue());
            pstmt.setDate(4, Date.valueOf(opp.getExpectedCloseDate()));
            pstmt.setInt(5, opp.getOwnerId());
            pstmt.executeUpdate();
        }
    }

    public Opportunity getOpportunityById(Connection conn, int opportunityId) throws SQLException {
        String sql = "SELECT * FROM Opportunity WHERE OpportunityID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, opportunityId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Opportunity(
                        rs.getInt("OpportunityID"),
                        rs.getInt("CustomerID"),
                        rs.getString("Stage"),
                        rs.getBigDecimal("Value"),
                        rs.getDate("ExpectedCloseDate").toLocalDate(),
                        rs.getTimestamp("CreatedAt").toLocalDateTime(),
                        rs.getInt("OwnerID")
                    );
                }
            }
        }
        return null;
    }
    
    public List<Opportunity> getAllOpportunities(Connection conn) throws SQLException {
        List<Opportunity> opportunities = new ArrayList<>();
        String sql = "SELECT * FROM Opportunity";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                opportunities.add(new Opportunity(
                    rs.getInt("OpportunityID"),
                    rs.getInt("CustomerID"),
                    rs.getString("Stage"),
                    rs.getBigDecimal("Value"),
                    rs.getDate("ExpectedCloseDate").toLocalDate(),
                    rs.getTimestamp("CreatedAt").toLocalDateTime(),
                    rs.getInt("OwnerID")
                ));
            }
        }
        return opportunities;
    }
}
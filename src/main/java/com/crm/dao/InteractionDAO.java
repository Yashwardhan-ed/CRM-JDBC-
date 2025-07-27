package com.crm.dao;

import com.crm.model.Interaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InteractionDAO {

    public void addInteraction(Connection conn, Interaction interaction) throws SQLException {
        String sql = "INSERT INTO Interaction (CustomerID, ContactID, TypeID, Subject, Notes, InteractionDate, CreatedBy) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, interaction.getCustomerId());
            pstmt.setInt(2, interaction.getContactId());
            pstmt.setInt(3, interaction.getTypeId());
            pstmt.setString(4, interaction.getSubject());
            pstmt.setString(5, interaction.getNotes());
            pstmt.setTimestamp(6, Timestamp.valueOf(interaction.getInteractionDate()));
            pstmt.setInt(7, interaction.getCreatedBy());
            pstmt.executeUpdate();
        }
    }

    public Interaction getInteractionById(Connection conn, int interactionId) throws SQLException {
        String sql = "SELECT * FROM Interaction WHERE InteractionID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, interactionId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Interaction(
                        rs.getInt("InteractionID"),
                        rs.getInt("CustomerID"),
                        rs.getInt("ContactID"),
                        rs.getInt("TypeID"),
                        rs.getString("Subject"),
                        rs.getString("Notes"),
                        rs.getTimestamp("InteractionDate").toLocalDateTime(),
                        rs.getInt("CreatedBy")
                    );
                }
            }
        }
        return null;
    }

    public List<Interaction> getAllInteractions(Connection conn) throws SQLException {
        List<Interaction> interactions = new ArrayList<>();
        String sql = "SELECT * FROM Interaction";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                interactions.add(new Interaction(
                    rs.getInt("InteractionID"),
                    rs.getInt("CustomerID"),
                    rs.getInt("ContactID"),
                    rs.getInt("TypeID"),
                    rs.getString("Subject"),
                    rs.getString("Notes"),
                    rs.getTimestamp("InteractionDate").toLocalDateTime(),
                    rs.getInt("CreatedBy")
                ));
            }
        }
        return interactions;
    }
}
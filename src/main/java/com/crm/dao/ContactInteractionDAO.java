package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crm.model.ContactInteraction;

public class ContactInteractionDAO {

    public void addContactInteraction(Connection conn, ContactInteraction ci) throws SQLException {
        String sql = "INSERT INTO ContactInteraction (ContactID, InteractionID) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ci.getContactId());
            pstmt.setInt(2, ci.getInteractionId());
            pstmt.executeUpdate();
        }
    }
}
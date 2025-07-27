package com.crm.dao;

import com.crm.model.LeadConversion;
import java.sql.*;

public class LeadConversionDAO {

    public void addLeadConversion(Connection conn, LeadConversion conversion) throws SQLException {
        String sql = "INSERT INTO LeadConversion (LeadID, OpportunityID, Description, ConversionDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, conversion.getLeadId());
            pstmt.setInt(2, conversion.getOpportunityId());
            pstmt.setString(3, conversion.getDescription());
            pstmt.setDate(4, Date.valueOf(conversion.getConversionDate()));
            pstmt.executeUpdate();
        }
    }
}
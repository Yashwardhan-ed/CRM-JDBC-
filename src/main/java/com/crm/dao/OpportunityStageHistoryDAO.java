package com.crm.dao;

import com.crm.model.OpportunityStageHistory;
import java.sql.*;

public class OpportunityStageHistoryDAO {

    public void addStageHistory(Connection conn, OpportunityStageHistory history) throws SQLException {
        String sql = "INSERT INTO OpportunityStageHistory (OpportunityID, PreviousStage, NewStage, ChangedBy) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, history.getOpportunityId());
            pstmt.setString(2, history.getPreviousStage());
            pstmt.setString(3, history.getNewStage());
            pstmt.setInt(4, history.getChangedBy());
            pstmt.executeUpdate();
        }
    }
}
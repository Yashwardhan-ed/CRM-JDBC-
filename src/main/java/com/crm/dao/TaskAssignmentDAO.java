package com.crm.dao;

import com.crm.model.TaskAssignment;
import java.sql.*;

public class TaskAssignmentDAO {

    public void assignTaskToUser(Connection conn, TaskAssignment assignment) throws SQLException {
        String sql = "INSERT INTO TaskAssignment (TaskID, UserID) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, assignment.getTaskId());
            pstmt.setInt(2, assignment.getUserId());
            pstmt.executeUpdate();
        }
    }
}
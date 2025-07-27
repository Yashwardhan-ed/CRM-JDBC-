package com.crm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.crm.model.Task;

public class TaskDAO {

    public void addTask(Connection conn, Task task) throws SQLException {
        String sql = "INSERT INTO Task (Title, Description, RelatedOpportunityID, DueDate, Status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            if (task.getRelatedOpportunityId() == 0) {
                pstmt.setNull(3, Types.INTEGER);
            } else {
                pstmt.setInt(3, task.getRelatedOpportunityId());
            }
            pstmt.setDate(4, Date.valueOf(task.getDueDate()));
            pstmt.setString(5, task.getStatus());
            pstmt.executeUpdate();
        }
    }

    public Task getTaskById(Connection conn, int taskId) throws SQLException {
        String sql = "SELECT * FROM Task WHERE TaskID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, taskId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Task(
                        rs.getInt("TaskID"),
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getInt("RelatedOpportunityID"),
                        rs.getDate("DueDate").toLocalDate(),
                        rs.getString("Status"),
                        rs.getTimestamp("CreatedAt").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }
    
    public void updateTaskStatus(Connection conn, int taskId, String newStatus) throws SQLException {
        String sql = "UPDATE Task SET Status = ? WHERE TaskID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, taskId);
            pstmt.executeUpdate();
        }
    }
}
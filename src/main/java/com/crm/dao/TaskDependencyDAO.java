package com.crm.dao;

import com.crm.model.TaskDependency;
import java.sql.*;

public class TaskDependencyDAO {

    public void addTaskDependency(Connection conn, TaskDependency dependency) throws SQLException {
        String sql = "INSERT INTO TaskDependency (TaskID, DependsOnTaskID) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, dependency.getTaskId());
            pstmt.setInt(2, dependency.getDependsOnTaskId());
            pstmt.executeUpdate();
        }
    }
}

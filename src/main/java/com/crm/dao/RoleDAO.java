package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crm.model.Role;

public class RoleDAO {

    public void addRole(Connection conn, Role dependency) throws SQLException {
        String sql = "INSERT INTO Role (RoleID, RoleName) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, dependency.getRoleId());
            pstmt.setString(2, dependency.getRoleName());
            pstmt.executeUpdate();
        }
    }
}

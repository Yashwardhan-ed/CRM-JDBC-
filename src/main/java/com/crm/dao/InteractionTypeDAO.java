package com.crm.dao;

import com.crm.model.InteractionType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InteractionTypeDAO {

    public void addInteractionType(Connection conn, InteractionType type) throws SQLException {
        String sql = "INSERT INTO InteractionType (TypeName) VALUES (?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type.getTypeName());
            pstmt.executeUpdate();
        }
    }

    public InteractionType getInteractionTypeById(Connection conn, int typeId) throws SQLException {
        String sql = "SELECT * FROM InteractionType WHERE TypeID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, typeId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new InteractionType(rs.getInt("TypeID"), rs.getString("TypeName"));
                }
            }
        }
        return null;
    }

    public List<InteractionType> getAllInteractionTypes(Connection conn) throws SQLException {
        List<InteractionType> types = new ArrayList<>();
        String sql = "SELECT * FROM InteractionType";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                types.add(new InteractionType(rs.getInt("TypeID"), rs.getString("TypeName")));
            }
        }
        return types;
    }
}
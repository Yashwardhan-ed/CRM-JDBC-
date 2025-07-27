package com.crm.dao;

import com.crm.model.OpportunityProduct;
import java.sql.*;

public class OpportunityProductDAO {

    public void addProductToOpportunity(Connection conn, OpportunityProduct op) throws SQLException {
        String sql = "INSERT INTO OpportunityProduct (OpportunityID, ProductID, Quantity, UnitPrice, Discount) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, op.getOpportunityId());
            pstmt.setInt(2, op.getProductId());
            pstmt.setInt(3, op.getQuantity());
            pstmt.setBigDecimal(4, op.getUnitPrice());
            pstmt.setBigDecimal(5, op.getDiscount());
            pstmt.executeUpdate();
        }
    }
}
package com.crm.dao;

import com.crm.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void addProduct(Connection conn, Product product) throws SQLException {
        String sql = "INSERT INTO Product (ProductID, ProductName, Description, Price, Category, CreatedAt) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, product.getProductId());
            pstmt.setString(2, product.getProductName());
            pstmt.setString(3, product.getDescription());
            pstmt.setBigDecimal(4, product.getPrice());
            pstmt.setString(5, product.getCategory());
            pstmt.setTimestamp(6, Timestamp.valueOf(product.getCreatedAt()));
            pstmt.executeUpdate();
        }
    }

    public Product getProductById(Connection conn, int productId) throws SQLException {
        String sql = "SELECT * FROM Product WHERE ProductID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Description"),
                        rs.getBigDecimal("Price"),
                        rs.getString("Category"),
                        rs.getTimestamp("CreatedAt").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }
    
    public List<Product> getAllProducts(Connection conn) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(
                    rs.getInt("ProductID"),
                    rs.getString("ProductName"),
                    rs.getString("Description"),
                    rs.getBigDecimal("Price"),
                    rs.getString("Category"),
                    rs.getTimestamp("CreatedAt").toLocalDateTime()
                ));
            }
        }
        return products;
    }
}
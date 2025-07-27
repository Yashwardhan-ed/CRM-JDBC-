package com.crm.dao;

import com.crm.model.Forecast;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ForecastDAO {

    public void addForecast(Connection conn, Forecast forecast) throws SQLException {
        String sql = "INSERT INTO Forecast (UserID, Month, ExpectedSales, ActualSales) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, forecast.getUserId());
            pstmt.setDate(2, Date.valueOf(forecast.getMonth()));
            pstmt.setBigDecimal(3, forecast.getExpectedSales());
            pstmt.setBigDecimal(4, forecast.getActualSales());
            pstmt.executeUpdate();
        }
    }

    public List<Forecast> getForecastsByUser(Connection conn, int userId) throws SQLException {
        List<Forecast> forecasts = new ArrayList<>();
        String sql = "SELECT * FROM Forecast WHERE UserID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    forecasts.add(new Forecast(
                        rs.getInt("ForecastID"),
                        rs.getInt("UserID"),
                        rs.getDate("Month").toLocalDate(),
                        rs.getBigDecimal("ExpectedSales"),
                        rs.getBigDecimal("ActualSales")
                    ));
                }
            }
        }
        return forecasts;
    }
}
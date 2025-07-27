package com.crm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Forecast {
    private int forecastId;
    private int userId;
    private LocalDate month;
    private BigDecimal expectedSales;
    private BigDecimal actualSales;

    public Forecast(int forecastId, int userId, LocalDate month, BigDecimal expectedSales, BigDecimal actualSales) {
        this.forecastId = forecastId;
        this.userId = userId;
        this.month = month;
        this.expectedSales = expectedSales;
        this.actualSales = actualSales;
    }
    
    // Getters and Setters
    public int getForecastId() { return forecastId; }
    public void setForecastId(int forecastId) { this.forecastId = forecastId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public LocalDate getMonth() { return month; }
    public void setMonth(LocalDate month) { this.month = month; }
    public BigDecimal getExpectedSales() { return expectedSales; }
    public void setExpectedSales(BigDecimal expectedSales) { this.expectedSales = expectedSales; }
    public BigDecimal getActualSales() { return actualSales; }
    public void setActualSales(BigDecimal actualSales) { this.actualSales = actualSales; }
}
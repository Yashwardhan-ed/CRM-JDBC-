package com.crm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UserPerformance {
    private LocalDate snapshotDate;
    private int userId;
    private int closedWon;
    private BigDecimal totalValue;

    public UserPerformance(LocalDate snapshotDate, int userId, int closedWon, BigDecimal totalValue) {
        this.snapshotDate = snapshotDate;
        this.userId = userId;
        this.closedWon = closedWon;
        this.totalValue = totalValue;
    }

    // Getters and Setters
    public LocalDate getSnapshotDate() { return snapshotDate; }
    public void setSnapshotDate(LocalDate snapshotDate) { this.snapshotDate = snapshotDate; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getClosedWon() { return closedWon; }
    public void setClosedWon(int closedWon) { this.closedWon = closedWon; }
    public BigDecimal getTotalValue() { return totalValue; }
    public void setTotalValue(BigDecimal totalValue) { this.totalValue = totalValue; }
}
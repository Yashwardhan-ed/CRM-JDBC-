package com.crm.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PipelineSnapshot {
    private LocalDate snapshotDate;
    private String stage;
    private int opportunityCount;
    private BigDecimal totalValue;

    public PipelineSnapshot(LocalDate snapshotDate, String stage, int opportunityCount, BigDecimal totalValue) {
        this.snapshotDate = snapshotDate;
        this.stage = stage;
        this.opportunityCount = opportunityCount;
        this.totalValue = totalValue;
    }

    // Getters and Setters
    public LocalDate getSnapshotDate() { return snapshotDate; }
    public void setSnapshotDate(LocalDate snapshotDate) { this.snapshotDate = snapshotDate; }
    public String getStage() { return stage; }
    public void setStage(String stage) { this.stage = stage; }
    public int getOpportunityCount() { return opportunityCount; }
    public void setOpportunityCount(int opportunityCount) { this.opportunityCount = opportunityCount; }
    public BigDecimal getTotalValue() { return totalValue; }
    public void setTotalValue(BigDecimal totalValue) { this.totalValue = totalValue; }
}
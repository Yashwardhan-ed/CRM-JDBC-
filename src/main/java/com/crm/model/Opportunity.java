package com.crm.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Opportunity {
    private int opportunityId;
    private int customerId;
    private String stage;
    private BigDecimal value;
    private LocalDate expectedCloseDate;
    private LocalDateTime createdAt;
    private int ownerId;

    public Opportunity(int opportunityId, int customerId, String stage, BigDecimal value, LocalDate expectedCloseDate, LocalDateTime createdAt, int ownerId) {
        this.opportunityId = opportunityId;
        this.customerId = customerId;
        this.stage = stage;
        this.value = value;
        this.expectedCloseDate = expectedCloseDate;
        this.createdAt = createdAt;
        this.ownerId = ownerId;
    }
    
    // Getters and Setters
    public int getOpportunityId() { return opportunityId; }
    public void setOpportunityId(int opportunityId) { this.opportunityId = opportunityId; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getStage() { return stage; }
    public void setStage(String stage) { this.stage = stage; }
    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }
    public LocalDate getExpectedCloseDate() { return expectedCloseDate; }
    public void setExpectedCloseDate(LocalDate expectedCloseDate) { this.expectedCloseDate = expectedCloseDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
}
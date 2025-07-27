package com.crm.model;

import java.time.LocalDateTime;

public class OpportunityStageHistory {
    private int historyId;
    private int opportunityId;
    private String previousStage;
    private String newStage;
    private LocalDateTime changedAt;
    private int changedBy;

    public OpportunityStageHistory(int historyId, int opportunityId, String previousStage, String newStage, LocalDateTime changedAt, int changedBy) {
        this.historyId = historyId;
        this.opportunityId = opportunityId;
        this.previousStage = previousStage;
        this.newStage = newStage;
        this.changedAt = changedAt;
        this.changedBy = changedBy;
    }

    // Getters and Setters
    public int getHistoryId() { return historyId; }
    public void setHistoryId(int historyId) { this.historyId = historyId; }
    public int getOpportunityId() { return opportunityId; }
    public void setOpportunityId(int opportunityId) { this.opportunityId = opportunityId; }
    public String getPreviousStage() { return previousStage; }
    public void setPreviousStage(String previousStage) { this.previousStage = previousStage; }
    public String getNewStage() { return newStage; }
    public void setNewStage(String newStage) { this.newStage = newStage; }
    public LocalDateTime getChangedAt() { return changedAt; }
    public void setChangedAt(LocalDateTime changedAt) { this.changedAt = changedAt; }
    public int getChangedBy() { return changedBy; }
    public void setChangedBy(int changedBy) { this.changedBy = changedBy; }
}
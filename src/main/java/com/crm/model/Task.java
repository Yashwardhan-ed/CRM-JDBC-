package com.crm.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    private int taskId;
    private String title;
    private String description;
    private int relatedOpportunityId;
    private LocalDate dueDate;
    private String status; // ENUM('pending', 'completed', 'overdue')
    private LocalDateTime createdAt;

    public Task(int taskId, String title, String description, int relatedOpportunityId, LocalDate dueDate, String status, LocalDateTime createdAt) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.relatedOpportunityId = relatedOpportunityId;
        this.dueDate = dueDate;
        this.status = status;
        this.createdAt = createdAt;
    }
    
    // Getters and Setters
    public int getTaskId() { return taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getRelatedOpportunityId() { return relatedOpportunityId; }
    public void setRelatedOpportunityId(int relatedOpportunityId) { this.relatedOpportunityId = relatedOpportunityId; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
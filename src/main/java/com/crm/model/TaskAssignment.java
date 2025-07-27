package com.crm.model;

public class TaskAssignment {
    private int taskId;
    private int userId;

    public TaskAssignment(int taskId, int userId) {
        this.taskId = taskId;
        this.userId = userId;
    }
    
    // Getters and Setters
    public int getTaskId() { return taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
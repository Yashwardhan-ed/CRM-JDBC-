package com.crm.model;

public class TaskDependency {
    private int taskId;
    private int dependsOnTaskId;

    public TaskDependency(int taskId, int dependsOnTaskId) {
        this.taskId = taskId;
        this.dependsOnTaskId = dependsOnTaskId;
    }
    
    // Getters and Setters
    public int getTaskId() { return taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }
    public int getDependsOnTaskId() { return dependsOnTaskId; }
    public void setDependsOnTaskId(int dependsOnTaskId) { this.dependsOnTaskId = dependsOnTaskId; }
}
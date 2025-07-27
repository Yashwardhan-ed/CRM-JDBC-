package com.crm.model;

public class UserOverdueTasks {
    private int userId;
    private int overdueCount;

    public UserOverdueTasks(int userId, int overdueCount) {
        this.userId = userId;
        this.overdueCount = overdueCount;
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getOverdueCount() { return overdueCount; }
    public void setOverdueCount(int overdueCount) { this.overdueCount = overdueCount; }
}
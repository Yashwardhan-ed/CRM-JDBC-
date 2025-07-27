package com.crm.model;

import java.time.LocalDateTime;

public class Customer {
    private int customerId;
    private String companyName;
    private String industry;
    private String location;
    private String email;
    private String phone;
    private LocalDateTime createdAt;

    public Customer(int customerId, String companyName, String industry, String location, String email, String phone, LocalDateTime createdAt) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.industry = industry;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
    return "Customer{" +
            "customerId=" + customerId +
            ", companyName='" + companyName + '\'' +
            ", industry='" + industry + '\'' +
            '}';
    }
}
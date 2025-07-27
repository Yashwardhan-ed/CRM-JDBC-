package com.crm.model;

import java.time.LocalDateTime;

public class Lead {
    private int leadId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;   
    private String company;
    private String status;
    private LocalDateTime createdAt;

    public Lead(int leadId, String firstName, String lastName, String email, String phone, String company, String status, LocalDateTime createdAt){
        this.leadId = leadId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getLeadId(){
        return leadId;
    }

    public void setLeadId(int leadId){
        this.leadId = leadId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
}


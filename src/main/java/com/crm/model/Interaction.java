package com.crm.model;

import java.time.LocalDateTime;

public class Interaction {
    private int interactionId;
    private int customerId;
    private int contactId;
    private int typeId;
    private String subject;
    private String notes;
    private LocalDateTime interactionDate;
    private int createdBy;

    public Interaction(int interactionId, int customerId, int contactId, int typeId, String subject, String notes, LocalDateTime interactionDate, int createdBy) {
        this.interactionId = interactionId;
        this.customerId = customerId;
        this.contactId = contactId;
        this.typeId = typeId;
        this.subject = subject;
        this.notes = notes;
        this.interactionDate = interactionDate;
        this.createdBy = createdBy;
    }
    
    public int getInteractionId() { return interactionId; }
    public void setInteractionId(int interactionId) { this.interactionId = interactionId; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public int getContactId() { return contactId; }
    public void setContactId(int contactId) { this.contactId = contactId; }
    public int getTypeId() { return typeId; }
    public void setTypeId(int typeId) { this.typeId = typeId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public LocalDateTime getInteractionDate() { return interactionDate; }
    public void setInteractionDate(LocalDateTime interactionDate) { this.interactionDate = interactionDate; }
    public int getCreatedBy() { return createdBy; }
    public void setCreatedBy(int createdBy) { this.createdBy = createdBy; }
}
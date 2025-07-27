package com.crm.model;

public class ContactInteraction {
    private int contactId;
    private int interactionId;

    public ContactInteraction(int contactId, int interactionId) {
        this.contactId = contactId;
        this.interactionId = interactionId;
    }
    
    // Getters and Setters
    public int getContactId() { return contactId; }
    public void setContactId(int contactId) { this.contactId = contactId; }
    public int getInteractionId() { return interactionId; }
    public void setInteractionId(int interactionId) { this.interactionId = interactionId; }
}
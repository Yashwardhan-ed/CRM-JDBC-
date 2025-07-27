package com.crm.model;

import java.time.LocalDateTime;

public class CustomerInteractionSummary {
    private int customerId;
    private int interactionCount;
    private LocalDateTime lastInteraction;

    public CustomerInteractionSummary(int customerId, int interactionCount, LocalDateTime lastInteraction) {
        this.customerId = customerId;
        this.interactionCount = interactionCount;
        this.lastInteraction = lastInteraction;
    }
    
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public int getInteractionCount() { return interactionCount; }
    public void setInteractionCount(int interactionCount) { this.interactionCount = interactionCount; }
    public LocalDateTime getLastInteraction() { return lastInteraction; }
    public void setLastInteraction(LocalDateTime lastInteraction) { this.lastInteraction = lastInteraction; }
}
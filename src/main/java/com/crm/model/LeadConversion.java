package com.crm.model;

import java.time.LocalDate;

public class LeadConversion {
    private int conversionId;
    private int leadId;
    private int opportunityId;
    private String description;
    private LocalDate conversionDate;

    public LeadConversion(int conversionId, int leadId, int opportunityId, String description, LocalDate conversionDate) {
        this.conversionId = conversionId;
        this.leadId = leadId;
        this.opportunityId = opportunityId;
        this.description = description;
        this.conversionDate = conversionDate;
    }

    // Getters and Setters
    public int getConversionId() { return conversionId; }
    public void setConversionId(int conversionId) { this.conversionId = conversionId; }
    public int getLeadId() { return leadId; }
    public void setLeadId(int leadId) { this.leadId = leadId; }
    public int getOpportunityId() { return opportunityId; }
    public void setOpportunityId(int opportunityId) { this.opportunityId = opportunityId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getConversionDate() { return conversionDate; }
    public void setConversionDate(LocalDate conversionDate) { this.conversionDate = conversionDate; }
}
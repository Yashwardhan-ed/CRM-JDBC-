package com.crm.model;

public class MonthlyLeadConversion {
    private String conversionMonth;
    private int convertedLeads;

    public MonthlyLeadConversion(String conversionMonth, int convertedLeads) {
        this.conversionMonth = conversionMonth;
        this.convertedLeads = convertedLeads;
    }
    
    public String getYearMonth() { return conversionMonth; }
    public void setYearMonth(String conversionMonth) { this.conversionMonth = conversionMonth; }
    public int getConvertedLeads() { return convertedLeads; }
    public void setConvertedLeads(int convertedLeads) { this.convertedLeads = convertedLeads; }
}
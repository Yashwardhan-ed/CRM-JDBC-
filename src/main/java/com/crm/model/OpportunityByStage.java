package com.crm.model;

import java.math.BigDecimal;

public class OpportunityByStage {
    private final String stage;
    private final int numberOfOpportunities;
    private final BigDecimal totalPotentialValue;
    public OpportunityByStage(String stage, int numberOfOpportunities, BigDecimal totalPotentialValue){
        this.stage = stage;
        this.numberOfOpportunities = numberOfOpportunities;
        this.totalPotentialValue = totalPotentialValue;
    }

    public String getStage(){ return stage; }
    public int getNumberOfOpportunities(){ return numberOfOpportunities; }
    public BigDecimal getTotalPotentialValue(){ return totalPotentialValue; }
}

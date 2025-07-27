package com.crm.model;

import java.math.BigDecimal;

public class UserPerformanceSummary {
    private final String fullName;
    private final int ClosedDealsCount;
    private final BigDecimal totalValueCount;

    public UserPerformanceSummary(String fullName, int ClosedDealsCount, BigDecimal totalValueCount){
        this.fullName = fullName;
        this.ClosedDealsCount = ClosedDealsCount;
        this.totalValueCount = totalValueCount;
    }

    public String getFullName(){ return fullName; }
    public int getClosedDealsCount(){ return ClosedDealsCount; }
    public BigDecimal getTotalValueCount(){ return totalValueCount; }
}

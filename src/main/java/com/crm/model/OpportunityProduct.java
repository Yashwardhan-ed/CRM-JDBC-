package com.crm.model;

import java.math.BigDecimal;

public class OpportunityProduct {
    private int opportunityId;
    private int productId;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal discount;

    public OpportunityProduct(int opportunityId, int productId, int quantity, BigDecimal unitPrice, BigDecimal discount) {
        this.opportunityId = opportunityId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    // Getters and Setters
    public int getOpportunityId() { return opportunityId; }
    public void setOpportunityId(int opportunityId) { this.opportunityId = opportunityId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public BigDecimal getDiscount() { return discount; }
    public void setDiscount(BigDecimal discount) { this.discount = discount; }
}
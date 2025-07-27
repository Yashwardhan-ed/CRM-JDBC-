package com.crm.model;

public class InteractionType {
    private int typeId;
    private String typeName;

    public InteractionType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    // Getters and Setters
    public int getTypeId() { return typeId; }
    public void setTypeId(int typeId) { this.typeId = typeId; }
    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
}
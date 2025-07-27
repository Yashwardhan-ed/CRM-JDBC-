package com.crm.model;

public class Contact {
    private int contactId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private int customerId;

    public Contact(int contactId, String firstName, String lastName, String email, String phone, String position, int customerId) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.customerId = customerId;
    }

    public int getContactId() { return contactId; }
    public void setContactId(int contactId) { this.contactId = contactId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
} 

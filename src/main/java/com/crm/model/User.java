package com.crm.model;

public class User {
    private int userId;
    private String FullName;
    private String Email;
    private int RoleID;
    public User(int userId, String FullName, String Email, int RoleID){
        this.userId = userId;
        this.FullName = FullName;
        this.Email = Email;
        this.RoleID = RoleID;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getFullName(){
        return FullName;
    }

    public void setFullName(String FullName){
        this.FullName = FullName;
    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public int getRoleID(){
        return RoleID;
    }

    public void setRoleID(int RoleID){
        this.RoleID = RoleID;
    }

    @Override
    public String toString(){
        return "Users {"+
        "UserId="+ userId + 
        "FullName=" + FullName +
        "Email=" + Email +
        "RoleId=" + RoleID +
        "}";
    }
}

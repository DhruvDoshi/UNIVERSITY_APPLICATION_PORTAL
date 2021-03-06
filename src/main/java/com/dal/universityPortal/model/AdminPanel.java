package com.dal.universityPortal.model;

public class AdminPanel {
    private int userId;
    private String username;
    private String email;
    private String type;
    private String status;

    public AdminPanel(){
    }

    public AdminPanel(int userId, String username, String email, String type, String status){
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.type = type;
        this.status = status;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
}

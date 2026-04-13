package com.rj.auth.login.domain.model;

public class Login_request_Entity {
    private String username;
    private String password;

    public Login_request_Entity(){

    }
    public Login_request_Entity(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}

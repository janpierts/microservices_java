package com.rj.auth.login.domain.model;

public class Login_request_pass_Entity {
    private String username;
    private Byte[] password;

    public Login_request_pass_Entity(){

    }
    public Login_request_pass_Entity(String username, Byte[] password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public Byte[] getPassword(){
        return password;
    }
    public void setPassword(Byte[] password){
        this.password = password;
    }
}

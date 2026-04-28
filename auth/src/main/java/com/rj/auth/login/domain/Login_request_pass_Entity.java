package com.rj.auth.login.domain;

public class Login_request_pass_Entity {
    private String username;
    private byte[] password;

    public Login_request_pass_Entity(){

    }
    public Login_request_pass_Entity(String username, byte[] password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public byte[] getPassword(){
        return password;
    }
    public void setPassword(byte[] password){
        this.password = password;
    }
}

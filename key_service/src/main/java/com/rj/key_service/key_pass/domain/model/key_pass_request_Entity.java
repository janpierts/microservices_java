package com.rj.key_service.key_pass.domain.model;

public class key_pass_request_Entity {
    private String pass_key;

    public key_pass_request_Entity() {
    }

    public key_pass_request_Entity(String pass_key) {
        this.pass_key = pass_key;
    }
    public String getPass_key() {
        return pass_key;
    }
    public void setPass_key(String pass_key) {
        this.pass_key = pass_key;
    }
}

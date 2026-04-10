package com.rj.key_service.key_pass.domain.model;

public class key_pass_JSON_Entity {
    private int id;
    private String pass_key;
    private boolean state;

    public key_pass_JSON_Entity() {
    }

    public key_pass_JSON_Entity(int id, String pass_key, boolean state) {
        this.id = id;
        this.pass_key = pass_key;
        this.state = state;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String get_PassKey() {
        return pass_key;
    }
    public void set_PassKey(String pass_key) {
        this.pass_key = pass_key;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
}

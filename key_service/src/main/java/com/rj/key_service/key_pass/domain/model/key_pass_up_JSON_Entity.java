package com.rj.key_service.key_pass.domain.model;

public class key_pass_up_JSON_Entity {
    private int id_passkey;
    private String pass_key;
    private int id_old_passkey;
    private String old_passkey;

    public key_pass_up_JSON_Entity() {
    }

    public key_pass_up_JSON_Entity(int id_passkey, String pass_key, int id_old_passkey, String old_passkey) {
        this.id_passkey = id_passkey;
        this.pass_key = pass_key;
        this.id_old_passkey = id_old_passkey;
        this.old_passkey = old_passkey;
    }
    public int getId_passkey() {
        return id_passkey;
    }
    public void setId_passkey(int id_passkey) {
        this.id_passkey = id_passkey;
    }
    public String getPassKey() {
        return pass_key;
    }
    public void setPassKey(String pass_key) {
        this.pass_key = pass_key;
    }
    public int getId_old_passkey() {
        return id_old_passkey;
    }
    public void setId_old_passkey(int id_old_passkey) {
        this.id_old_passkey = id_old_passkey;
    }
    public String getOld_passkey() {
        return old_passkey;
    }
    public void setOld_passkey(String old_passkey) {
        this.old_passkey = old_passkey;
    }
}

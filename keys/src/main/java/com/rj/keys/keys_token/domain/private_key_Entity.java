package com.rj.keys.keys_token.domain;

public class private_key_Entity {
    private String privateKey;

    public private_key_Entity() {
    }

    public private_key_Entity(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}

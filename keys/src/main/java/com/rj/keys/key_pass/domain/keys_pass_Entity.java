package com.rj.keys.key_pass.domain;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import com.fasterxml.jackson.annotation.JsonFormat;

@RedisHash("pass-renewal-keys")
public class keys_pass_Entity {
    @Id
    private int id;
    private String pass_key;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime updatedAt;
    private boolean state;

    public keys_pass_Entity() {
    }

    public keys_pass_Entity(int id, String pass_key, String privateKey, LocalDateTime createdAt, LocalDateTime updatedAt,
            boolean state) {
        this.id = id;
        this.pass_key = pass_key;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.state = state;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassKey() {
        return pass_key;
    }
    public void setPassKey(String pass_key) {
        this.pass_key = pass_key;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
}

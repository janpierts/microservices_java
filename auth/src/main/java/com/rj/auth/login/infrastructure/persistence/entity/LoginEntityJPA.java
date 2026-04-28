package com.rj.auth.login.infrastructure.persistence.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.rj.auth.login.domain.Login_request_pass_Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoginEntityJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger users_id;

    @Column( name = "user_name")
    private String user_name;

    @Column( name = "user_password")
    private byte[] user_password;

    @Column( name = "id_passkey")
    private long id_passkey;

    @Column( name = "user_created")
    private BigInteger user_created;

    @Column( name = "created")
    private LocalDateTime created;

    @Column( name = "user_updated")
    private BigInteger user_updated;

    @Column( name = "updated")
    private LocalDateTime updated;

    @Column( name = "state")
    private boolean state;

    @Column( name = "deleted")
    private boolean deleted;

    @Column( name = "employees_id")
    private BigInteger employees_id;

    @Column( name = "client_id")
    private BigInteger client_id;

    public LoginEntityJPA() {

    }
    public LoginEntityJPA(Login_request_pass_Entity DomainEntity){
        this.user_name = DomainEntity.getUsername();
        this.user_password = DomainEntity.getPassword();
        this.id_passkey = 0;
        this.user_created = BigInteger.valueOf(1);
        this.created = LocalDateTime.now();
        this.user_updated = BigInteger.valueOf(1);
        this.updated = LocalDateTime.now();
        this.state = true;
        this.deleted = false;
        this.employees_id = BigInteger.valueOf(1);
        this.client_id = BigInteger.valueOf(1);
    }
    public BigInteger getUsers_id() {
        return users_id;
    }
    public void setUsers_id(BigInteger users_id) {
        this.users_id = users_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public byte[] getUser_password() {
        return user_password;
    }
    public void setUser_password(byte[] user_password) {
        this.user_password = user_password;
    }
    public long getId_passkey() {
        return id_passkey;
    }
    public void setId_passkey(long id_passkey) {
        this.id_passkey = id_passkey;
    }
    public BigInteger getUser_created() {
        return user_created;
    }
    public void setUser_created(BigInteger user_created) {
        this.user_created = user_created;
    }
    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public BigInteger getUser_updated() {
        return user_updated;
    }
    public void setUser_updated(BigInteger user_updated) {
        this.user_updated = user_updated;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public BigInteger getEmployees_id() {
        return employees_id;
    }
    public void setEmployees_id(BigInteger employees_id) {
        this.employees_id = employees_id;
    }
}

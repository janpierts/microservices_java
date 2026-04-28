package com.rj.auth.login.domain;

import java.math.BigInteger;

public class Login_user_Entity {
    private BigInteger users_id;


    public Login_user_Entity() {

    }
    public Login_user_Entity(BigInteger users_id, String user_name, long id_passkey, boolean state, boolean deleted){
        this.users_id = users_id;
    }
    public BigInteger getUsers_id(){
        return users_id;
    }
    public void setUsers_id(BigInteger users_id){
        this.users_id = users_id;
    }
}

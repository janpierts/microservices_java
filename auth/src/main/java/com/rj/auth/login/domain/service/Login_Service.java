package com.rj.auth.login.domain.service;

import org.springframework.stereotype.Service;

import com.rj.auth.login.domain.model.Login_request_Entity;
import com.rj.auth.login.domain.model.Login_user_Entity;
import com.rj.auth.login.domain.ports.in.Login_ServicePort;
import com.rj.auth.login.domain.ports.out.Login_RepositoryPort;

@Service
public class Login_Service implements Login_ServicePort{
    private final Login_RepositoryPort repositoryPorts;
    public Login_Service(Login_RepositoryPort repositoryPorts) {
        this.repositoryPorts = repositoryPorts;
    }
    @Override
    public Login_user_Entity login(Login_request_Entity entity){
        return repositoryPorts.login(entity);
    }
}

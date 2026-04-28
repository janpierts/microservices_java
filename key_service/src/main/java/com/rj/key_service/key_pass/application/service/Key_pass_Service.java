package com.rj.key_service.key_pass.application.service;

import org.springframework.stereotype.Service;

import com.rj.key_service.key_pass.domain.key_pass_Entity;
import com.rj.key_service.key_pass.domain.key_pass_request_Entity;
import com.rj.key_service.key_pass.application.ports.in.Key_pass_ServicePort;
import com.rj.key_service.key_pass.application.ports.out.Key_pass_RepositoryPort;

@Service
public class Key_pass_Service implements Key_pass_ServicePort {
    private final Key_pass_RepositoryPort repositoryPorts;
    public Key_pass_Service(Key_pass_RepositoryPort repositoryPorts) {
        this.repositoryPorts = repositoryPorts;
    }
    @Override
    public key_pass_Entity SetPassKeyWord(key_pass_request_Entity request) {
        return repositoryPorts.SetPassKeyWord(request);
    }
}
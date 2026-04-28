package com.rj.key_service.key.application.service;

import org.springframework.stereotype.Service;

import com.rj.key_service.key.application.ports.in.Keys_ServicePort;
import com.rj.key_service.key.application.ports.out.Keys_RepositoryPort;
import com.rj.key_service.key.domain.keys_Entity;

@Service
public class Keys_Service implements Keys_ServicePort {
    private final Keys_RepositoryPort repositoryPorts;
    public Keys_Service(Keys_RepositoryPort repositoryPorts) {
        this.repositoryPorts = repositoryPorts;
    }
    @Override
    public keys_Entity SetKey() {
        return repositoryPorts.SetKey();
    }
}
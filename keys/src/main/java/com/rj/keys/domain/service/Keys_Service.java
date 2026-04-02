package com.rj.keys.domain.service;

import org.springframework.stereotype.Service;
import com.rj.keys.domain.model.public_keys_Entity;
import com.rj.keys.domain.ports.in.Keys_ServicePort;
import com.rj.keys.domain.ports.out.Keys_RepositoryPort;

@Service
public class Keys_Service implements Keys_ServicePort {
    private final Keys_RepositoryPort repositoryPorts;
    public Keys_Service(Keys_RepositoryPort repositoryPorts) {
        this.repositoryPorts = repositoryPorts;
    }
    @Override
    public public_keys_Entity SetKey() {
        return repositoryPorts.SetKey();
    }
}
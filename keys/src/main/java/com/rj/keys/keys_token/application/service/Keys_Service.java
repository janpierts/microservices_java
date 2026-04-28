package com.rj.keys.keys_token.application.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.rj.keys.keys_token.application.ports.in.Keys_ServicePort;
import com.rj.keys.keys_token.application.ports.out.Keys_RepositoryPort;
import com.rj.keys.keys_token.domain.private_key_Entity;
import com.rj.keys.keys_token.domain.public_keys_Entity;

@Service
public class Keys_Service implements Keys_ServicePort {
    private final Keys_RepositoryPort repositoryPorts;
    public Keys_Service(Keys_RepositoryPort repositoryPorts) {
        this.repositoryPorts = repositoryPorts;
    }
    @Override
    public List<public_keys_Entity> getPublicKeys() {
        return repositoryPorts.getPublicKeys();
    }
    @Override
    public private_key_Entity getPrivateKey() {
        return repositoryPorts.getPrivateKey();
    }
}
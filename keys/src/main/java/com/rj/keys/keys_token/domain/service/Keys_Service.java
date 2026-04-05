package com.rj.keys.keys_token.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.rj.keys.keys_token.domain.model.private_key_Entity;
import com.rj.keys.keys_token.domain.model.public_keys_Entity;
import com.rj.keys.keys_token.domain.ports.in.Keys_ServicePort;
import com.rj.keys.keys_token.domain.ports.out.Keys_RepositoryPort;

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
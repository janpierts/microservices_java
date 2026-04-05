package com.rj.keys.key_pass.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.rj.keys.key_pass.domain.model.keys_pass_Entity;
import com.rj.keys.key_pass.domain.ports.in.Keys_Pass_ServicePort;
import com.rj.keys.key_pass.domain.ports.out.Keys_Pass_RepositoryPort;

@Service
public class Keys_Pass_Service implements Keys_Pass_ServicePort {
    private final Keys_Pass_RepositoryPort repositoryPorts;
    public Keys_Pass_Service(Keys_Pass_RepositoryPort repositoryPorts) {
        this.repositoryPorts = repositoryPorts;
    }
    @Override
    public List<keys_pass_Entity> getPassKeys() {
        return repositoryPorts.getPassKeys();
    }
}
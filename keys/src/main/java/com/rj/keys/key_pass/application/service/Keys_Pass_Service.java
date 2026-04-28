package com.rj.keys.key_pass.application.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.rj.keys.key_pass.application.ports.in.Keys_Pass_ServicePort;
import com.rj.keys.key_pass.application.ports.out.Keys_Pass_RepositoryPort;
import com.rj.keys.key_pass.domain.keys_pass_Entity;

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
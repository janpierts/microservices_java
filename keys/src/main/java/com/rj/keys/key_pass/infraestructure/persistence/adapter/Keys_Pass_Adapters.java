package com.rj.keys.key_pass.infraestructure.persistence.adapter;

import com.rj.keys.key_pass.domain.model.keys_pass_Entity;
import com.rj.keys.key_pass.domain.ports.out.Keys_Pass_RepositoryPort;
import com.rj.keys.key_pass.infraestructure.persistence.repository.KeysRedisRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Keys_Pass_Adapters implements Keys_Pass_RepositoryPort {
    private final KeysRedisRepository repository;
    public Keys_Pass_Adapters(KeysRedisRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<keys_pass_Entity> getPassKeys() {
        List<keys_pass_Entity> keys = new ArrayList<>();
        repository.findAll().forEach(keys::add);
        return keys;
    }
}

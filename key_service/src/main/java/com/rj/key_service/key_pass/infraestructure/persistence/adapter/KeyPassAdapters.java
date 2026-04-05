package com.rj.key_service.key_pass.infraestructure.persistence.adapter;

import com.rj.key_service.key_pass.domain.model.key_pass_Entity;
import com.rj.key_service.key_pass.domain.ports.out.Key_pass_RepositoryPort;
import com.rj.key_service.key_pass.infraestructure.persistence.repository.KeysRedisRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class KeyPassAdapters implements Key_pass_RepositoryPort {
    private final KeysRedisRepository repository;
    public KeyPassAdapters(KeysRedisRepository repository) {
        this.repository = repository;
    }

    @Override
    public key_pass_Entity SetPassKeyWord(String passKeyWord) {
        List<key_pass_Entity> existsKeys = new ArrayList<>();
        try {
            repository.findAll().forEach(existsKeys::add);
            LocalDateTime now = LocalDateTime.now();

            if (existsKeys.isEmpty()) {
                return saveNewKey(1, passKeyWord, true, now);

            } else if (existsKeys.size() == 1) {
                rotateKey(existsKeys.get(0), 2, false, now);
                return saveNewKey(1, passKeyWord, true, now);

            } else {
                key_pass_Entity oldKey = existsKeys.stream().filter(k -> k.getId() == 2).findFirst().orElse(existsKeys.get(1));
                repository.delete(oldKey);

                key_pass_Entity currentKey = existsKeys.stream().filter(k -> k.getId() == 1).findFirst().orElse(existsKeys.get(0));
                rotateKey(currentKey, 2, false, now);

                return saveNewKey(1, passKeyWord, true, now);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error en la rotación de llaves: " + e.getMessage());
        }
    }

    private key_pass_Entity saveNewKey(int id, String pass, boolean state, LocalDateTime now) {
        key_pass_Entity newKey = new key_pass_Entity();
        newKey.setId(id);
        newKey.setPassKey(pass);
        newKey.setCreatedAt(now);
        newKey.setUpdatedAt(now);
        newKey.setState(state);
        return repository.save(newKey);
    }

    private void rotateKey(key_pass_Entity key, int newId, boolean newState, LocalDateTime now) {
        repository.delete(key);
        key.setId(newId);
        key.setState(newState);
        key.setUpdatedAt(now);
        repository.save(key);
    }
}

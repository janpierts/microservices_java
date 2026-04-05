package com.rj.key_service.key_pass.infraestructure.persistence.adapter;

import com.rj.key_service.key_pass.domain.model.key_pass_Entity;
import com.rj.key_service.key_pass.domain.ports.out.Key_pass_RepositoryPort;
import com.rj.key_service.key_pass.infraestructure.persistence.repository.KeysRedisRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class KeyPassAdapters implements Key_pass_RepositoryPort {
    private final JdbcTemplate jdbcTemplate;
    private final KeysRedisRepository repository;
    public KeyPassAdapters(KeysRedisRepository repository, JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public key_pass_Entity SetPassKeyWord(String passKeyWord) {
        String sql = "{ call jbAPI_updateKeypass(?,?,?,?) }"; 
        List<key_pass_Entity> existsKeys = new ArrayList<>();
        try {
            repository.findAll().forEach(existsKeys::add);
            LocalDateTime now = LocalDateTime.now();

            if (existsKeys.isEmpty()) {
                jdbcTemplate.update(sql, passKeyWord, existsKeys.size()+1, "", 0);
                return saveNewKey(0, passKeyWord, true, now, existsKeys);

            } else{
                String oldPassKey = existsKeys.stream().filter(k -> k.isState()).findFirst().map(key_pass_Entity::getPassKey).orElse("");
                jdbcTemplate.update(sql, passKeyWord, existsKeys.size()+1, oldPassKey, existsKeys.size());
                return saveNewKey(existsKeys.size(), passKeyWord, true, now, existsKeys);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error en la rotación de llaves: " + e.getMessage());
        }
    }

    private key_pass_Entity saveNewKey(int id, String pass, boolean state, LocalDateTime now, List<key_pass_Entity> old_keys) {
        old_keys.stream()
            .filter(k -> k.isState())
            .forEach(key -> {
                key.setState(false);
                repository.save(key);
        });
        key_pass_Entity newKey = new key_pass_Entity();
        newKey.setId(id++);
        newKey.setPassKey(pass);
        newKey.setCreatedAt(now);
        newKey.setUpdatedAt(now);
        newKey.setState(state);
        return repository.save(newKey);
    }
}

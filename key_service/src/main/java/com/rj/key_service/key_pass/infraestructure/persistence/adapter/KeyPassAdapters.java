package com.rj.key_service.key_pass.infraestructure.persistence.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rj.key_service.key_pass.domain.model.key_pass_Entity;
import com.rj.key_service.key_pass.domain.model.key_pass_JSON_Entity;
import com.rj.key_service.key_pass.domain.model.key_pass_up_JSON_Entity;
import com.rj.key_service.key_pass.domain.ports.out.Key_pass_RepositoryPort;
import com.rj.key_service.key_pass.infraestructure.persistence.repository.KeyPassRedisRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class KeyPassAdapters implements Key_pass_RepositoryPort {
    private final JdbcTemplate jdbcTemplate;
    private final KeyPassRedisRepository repository;
    public KeyPassAdapters(KeyPassRedisRepository repository, JdbcTemplate jdbcTemplate) {
        this.repository = repository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public key_pass_Entity SetPassKeyWord(String passKeyWord) {
        ObjectMapper objectMapper = new ObjectMapper();
        String sql = "{ call jbAPI_updateKeypass(?) }"; 
        key_pass_up_JSON_Entity JsonToUpdate = new key_pass_up_JSON_Entity();
        JsonToUpdate.setPassKey(passKeyWord);
        List<key_pass_Entity> existsKeys = new ArrayList<>();
        String jsonEntities = "";
        try {
            repository.findAll().forEach(existsKeys::add);
            LocalDateTime now = LocalDateTime.now();

            if (existsKeys.isEmpty()) {
                JsonToUpdate.setId_passkey(1);
                jsonEntities = objectMapper.writeValueAsString(JsonToUpdate);
                jdbcTemplate.update(sql, jsonEntities);
                return saveNewKey(0, passKeyWord, true, now, existsKeys);

            } else{
                String sqllistKeyPass = "{ call jbAPI_listAllKeypass()}";
                String oldPassKey = existsKeys.stream().filter(k -> k.isState()).findFirst().map(key_pass_Entity::getPassKey).orElse("");
                JsonToUpdate.setId_passkey(existsKeys.size()+1);
                JsonToUpdate.setId_old_passkey(existsKeys.size());
                JsonToUpdate.setOld_passkey(oldPassKey);
                jsonEntities = objectMapper.writeValueAsString(JsonToUpdate);
                jdbcTemplate.update(sql, jsonEntities);
                key_pass_Entity  newKey = saveNewKey(existsKeys.size(), passKeyWord, true, now, existsKeys); 
                List<Integer> idKeypass = jdbcTemplate.queryForList(sqllistKeyPass,Integer.class);
                if(idKeypass.size() > 1){
                    existsKeys.clear();
                    repository.findAll().forEach(existsKeys::add);
                    idKeypass = idKeypass.stream()
                        .filter(id -> id != existsKeys.stream()
                            .filter(k -> k.isState())
                            .findFirst()
                            .map(key_pass_Entity::getId)
                            .orElse(0)
                        ).toList();
                    
                    String sqlupKeyPass = "{ call jbAPI_updateAllKeypass(?)}";
                    List<key_pass_JSON_Entity> filteredJSONEntities = new ArrayList<>();
                    filteredJSONEntities.add(existsKeys.stream().filter(k -> k.isState()).map(k -> new key_pass_JSON_Entity(k.getId(), k.getPassKey(), k.isState())).findFirst().orElse(null));
                    idKeypass.forEach(id -> {
                        existsKeys.stream()
                            .filter(k -> k.getId() ==id)
                            .findFirst()
                            .ifPresent(k -> filteredJSONEntities.add(new key_pass_JSON_Entity(k.getId(), k.getPassKey(), k.isState()))); 
                    });
                    jsonEntities = objectMapper.writeValueAsString(filteredJSONEntities);
                    jdbcTemplate.update(sqlupKeyPass, jsonEntities);
                }
                return newKey;
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

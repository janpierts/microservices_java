package com.rj.key_service.key.infraestructure.persistence.adapter;

import com.rj.key_service.key.domain.model.keys_Entity;
import com.rj.key_service.key.domain.ports.out.Keys_RepositoryPort;
import com.rj.key_service.key.infraestructure.persistence.repository.KeyRedisRepository;
import com.rj.key_service.utils.KeyGeneratorUtils;
import java.security.KeyPair;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class KeysAdapters implements Keys_RepositoryPort {
    private final KeyRedisRepository repository;
    private final RedisTemplate<String, Object> redisTemplate;
    public KeysAdapters(KeyRedisRepository repository, RedisTemplate<String, Object> redisTemplate) {
        this.repository = repository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public keys_Entity SetKey() {
        List<keys_Entity> existsKeys = new ArrayList<>();
        try {
            repository.findAll().forEach(existsKeys::add);
            KeyPair keyPair = KeyGeneratorUtils.generateRSAKeyPair();
            String publicKeyStr = KeyGeneratorUtils.keyToString(keyPair.getPublic());
            String privateKeyStr = KeyGeneratorUtils.keyToString(keyPair.getPrivate());

            LocalDateTime now = LocalDateTime.now();

            if (existsKeys.isEmpty()) {
                return saveNewKey(1, publicKeyStr, privateKeyStr, true, now);

            } else if (existsKeys.size() == 1) {
                rotateKey(existsKeys.get(0), 2, false, now);
                return saveNewKey(1, publicKeyStr, privateKeyStr, true, now);

            } else {
                keys_Entity oldKey = existsKeys.stream().filter(k -> k.getId() == 2).findFirst().orElse(existsKeys.get(1));
                repository.delete(oldKey);

                keys_Entity currentKey = existsKeys.stream().filter(k -> k.getId() == 1).findFirst().orElse(existsKeys.get(0));
                rotateKey(currentKey, 2, false, now);

                return saveNewKey(1, publicKeyStr, privateKeyStr, true, now);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error en la rotación de llaves: " + e.getMessage());
        }
    }

    private keys_Entity saveNewKey(int id, String pub, String priv, boolean state, LocalDateTime now) {
        keys_Entity newKey = new keys_Entity();
        newKey.setId(id);
        newKey.setPublicKey(pub);
        newKey.setCreatedAt(now);
        newKey.setUpdatedAt(now);
        newKey.setState(state);
        String privateKeyKey = "auth:secret:private_key:" + id;
        redisTemplate.opsForValue().set(privateKeyKey, priv);

        return repository.save(newKey);
    }

    private void rotateKey(keys_Entity key, int newId, boolean newState, LocalDateTime now) {
        repository.delete(key);
        key.setId(newId);
        key.setState(newState);
        key.setUpdatedAt(now);
        repository.save(key);
    }
}

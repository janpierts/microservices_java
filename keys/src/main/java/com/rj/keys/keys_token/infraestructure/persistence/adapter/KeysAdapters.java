package com.rj.keys.keys_token.infraestructure.persistence.adapter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import com.rj.keys.keys_token.domain.model.private_key_Entity;
import com.rj.keys.keys_token.domain.model.public_keys_Entity;
import com.rj.keys.keys_token.domain.ports.out.Keys_RepositoryPort;
import com.rj.keys.keys_token.infraestructure.persistence.repository.KeysRedisRepository;

@Component
public class KeysAdapters implements Keys_RepositoryPort {
    private final KeysRedisRepository repository;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    public KeysAdapters(KeysRedisRepository repository,StringRedisTemplate stringRedisTemplate) {
        this.repository = repository;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public List<public_keys_Entity> getPublicKeys() {
        List<public_keys_Entity> keys = new ArrayList<>();
        repository.findAll().forEach(keys::add);
        return keys;
    }
    @Override
    public private_key_Entity getPrivateKey() {
        String rawKey = stringRedisTemplate.opsForValue().get("auth:secret:private_key:1");
        rawKey = rawKey.replace("\"", "");
        return new private_key_Entity(rawKey);
    }
}

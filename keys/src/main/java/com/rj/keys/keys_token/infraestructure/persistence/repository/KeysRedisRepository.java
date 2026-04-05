package com.rj.keys.keys_token.infraestructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rj.keys.keys_token.domain.model.public_keys_Entity;

@Repository
public interface KeysRedisRepository extends CrudRepository<public_keys_Entity, Integer> {
    
}
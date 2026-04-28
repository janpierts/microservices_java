package com.rj.keys.keys_token.infraestructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rj.keys.keys_token.domain.public_keys_Entity;

@Repository
public interface KeysTokenRedisRepository extends CrudRepository<public_keys_Entity, Integer> {
    
}
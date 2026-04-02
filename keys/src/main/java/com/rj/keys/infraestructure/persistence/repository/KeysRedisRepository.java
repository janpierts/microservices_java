package com.rj.keys.infraestructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rj.keys.domain.model.public_keys_Entity;

@Repository
public interface KeysRedisRepository extends CrudRepository<public_keys_Entity, Integer> {

}
package com.rj.keys.key_pass.infraestructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rj.keys.key_pass.domain.model.keys_pass_Entity;

@Repository
public interface KeysPassRedisRepository extends CrudRepository<keys_pass_Entity, Integer> {

}
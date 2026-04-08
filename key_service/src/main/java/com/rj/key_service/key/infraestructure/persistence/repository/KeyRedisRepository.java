package com.rj.key_service.key.infraestructure.persistence.repository;

import com.rj.key_service.key.domain.model.keys_Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRedisRepository extends CrudRepository<keys_Entity, Integer> {

}
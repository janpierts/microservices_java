package com.rj.key_service.key.infraestructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rj.key_service.key.domain.keys_Entity;

@Repository
public interface KeyRedisRepository extends CrudRepository<keys_Entity, Integer> {

}
package com.rj.key_service.key_pass.infraestructure.persistence.repository;

import com.rj.key_service.key_pass.domain.model.key_pass_Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyPassRedisRepository extends CrudRepository<key_pass_Entity, Integer> {

}
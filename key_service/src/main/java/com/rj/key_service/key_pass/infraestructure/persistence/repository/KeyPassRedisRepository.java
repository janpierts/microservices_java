package com.rj.key_service.key_pass.infraestructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rj.key_service.key_pass.domain.key_pass_Entity;

@Repository
public interface KeyPassRedisRepository extends CrudRepository<key_pass_Entity, Integer> {

}
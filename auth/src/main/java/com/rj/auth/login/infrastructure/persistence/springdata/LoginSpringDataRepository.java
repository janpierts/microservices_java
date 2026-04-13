package com.rj.auth.login.infrastructure.persistence.springdata;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rj.auth.login.infrastructure.persistence.entity.LoginEntityJPA;

@Repository
public interface LoginSpringDataRepository extends JpaRepository<LoginEntityJPA, BigInteger> {
    LoginEntityJPA findByUser_name(String user_name);
}

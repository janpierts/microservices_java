package com.rj.auth.login.infrastructure.persistence.adapters;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rj.auth.login.domain.Login_request_Entity;
import com.rj.auth.login.domain.Login_user_Entity;
import com.rj.auth.login.application.ports.out.Login_RepositoryPort;
import com.rj.auth.login.infrastructure.persistence.springdata.LoginSpringDataRepository;
import com.rj.auth.utils.settings.JPAConfig;
import jakarta.persistence.EntityManager;

@Component
public class LoginAdapter implements Login_RepositoryPort {
    @Value("${spring.datasource.url}")
    private String datasourceUrl;
    @Value("${spring.datasource.username}")
    private String datasourceUsername;
    @Value("${spring.datasource.password}")
    private String datasourcePassword;
    @Value("${spring.datasource.driver-class-name}")
    private String datasourceDriverClassName;
    @Value("${api.auth.login.privateKey}")
    private String privateKeyEndpoint;
    @Value("${api.auth.login.passKey}")
    private String passKeyEndpoint;
    private RestTemplate restTemplate;
    private final LoginSpringDataRepository jpaRepository;
    private final JPAConfig jpaConfig;
    private volatile EntityManager entityManager;
    public LoginAdapter(/*RestTemplate restTemplate,*/LoginSpringDataRepository jpaRepository, JPAConfig jpaConfig) {
        //this.restTemplate = restTemplate;
        this.jpaRepository = jpaRepository;
        this.jpaConfig = jpaConfig;
    }
    private EntityManager getDynamicEntityManager() {
        if (this.entityManager == null) {
            synchronized (this) {
                if (this.entityManager == null) {
                    List<String> packagesToScan = List.of("com.rj.auth.login.infrastructure.persistence.entity");
                    this.entityManager = jpaConfig.buildEntityManager(datasourceUrl, datasourceUsername, datasourcePassword, datasourceDriverClassName, packagesToScan);
                }
            }
        }
        return this.entityManager;
    }
    @Override
    public Login_user_Entity login(Login_request_Entity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
 
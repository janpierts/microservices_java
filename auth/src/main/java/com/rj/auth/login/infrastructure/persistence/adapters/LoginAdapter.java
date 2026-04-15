package com.rj.auth.login.infrastructure.persistence.adapters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoginAdapter {
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
    private final RestTemplate restTemplate;
    public LoginAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}

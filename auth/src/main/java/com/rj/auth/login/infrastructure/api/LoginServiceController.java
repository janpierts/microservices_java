package com.rj.auth.login.infrastructure.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.auth.login.domain.model.Login_request_Entity;
import com.rj.auth.login.domain.model.Login_user_Entity;
import com.rj.auth.login.domain.service.Login_Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth/login")
public class LoginServiceController {
    private final Login_Service loginService;
    public LoginServiceController(Login_Service loginService) {
        this.loginService = loginService;
    }
    @PostMapping("validation")
    public ResponseEntity<Login_user_Entity> login(@RequestBody Login_request_Entity entity) {
        Login_user_Entity user = loginService.login(entity);
        return new ResponseEntity<>(user, user != null ? org.springframework.http.HttpStatus.OK : org.springframework.http.HttpStatus.UNAUTHORIZED);
    }
    
}

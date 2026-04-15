package com.rj.auth.login.infrastructure.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rj.auth.login.domain.model.Login_request_Entity;
import com.rj.auth.login.domain.model.Login_user_Entity;
import com.rj.auth.login.domain.service.Login_Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.rj.auth.utils.helperEndpoints;


@RestController
@RequestMapping("/api/auth/login")
public class LoginServiceController {
    private final Login_Service loginService;
    public LoginServiceController(Login_Service loginService) {
        this.loginService = loginService;
    }
    @PostMapping("validation")
    public ResponseEntity<Login_user_Entity> login(@RequestBody Login_request_Entity entity) {
        Login_user_Entity user = null;
        if(!entity.getUsername().isEmpty() && !entity.getUsername().isBlank() && helperEndpoints.isValidForSearch(entity.getUsername(),helperEndpoints.SearchType.SAFE_TEXT) && !helperEndpoints.containsAnyWhitespace(entity.getUsername()) && !entity.getPassword().isEmpty() && !entity.getPassword().isBlank() && helperEndpoints.isValidForSearch(entity.getPassword(),helperEndpoints.SearchType.SAFE_TEXT) && !helperEndpoints.containsAnyWhitespace(entity.getPassword())) {
            String username = entity.getUsername();
            String password = entity.getPassword();
            if(username.length() >= 5 && username.length() <= 50 && password.length() >= 8 && password.length() <= 100) {
                user = loginService.login(entity);
            }
        }
        return new ResponseEntity<>(user, user != null ? org.springframework.http.HttpStatus.OK : org.springframework.http.HttpStatus.UNAUTHORIZED);
    }
    
}

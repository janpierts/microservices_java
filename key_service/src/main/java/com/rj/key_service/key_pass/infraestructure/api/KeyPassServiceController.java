package com.rj.key_service.key_pass.infraestructure.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.key_service.key_pass.domain.key_pass_Entity;
import com.rj.key_service.key_pass.domain.key_pass_request_Entity;
import com.rj.key_service.key_pass.application.service.Key_pass_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/security/passkeys")
public class KeyPassServiceController {
    private final Key_pass_Service keysService;
    public KeyPassServiceController(Key_pass_Service keysService) {
        this.keysService = keysService;
    }
    @PostMapping("SetPassKeyWord")
    public ResponseEntity<key_pass_Entity> SetPassKeyWord(@RequestBody key_pass_request_Entity request) {
        key_pass_Entity key = keysService.SetPassKeyWord(request);
        return new ResponseEntity<>(key, HttpStatus.CREATED);
    }
}

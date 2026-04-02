package com.rj.keys.infraestructure.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rj.keys.domain.model.public_keys_Entity;
import com.rj.keys.domain.service.Keys_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/security/keys")
public class KeysServiceController {
    private final Keys_Service keysService;
    public KeysServiceController(Keys_Service keysService) {
        this.keysService = keysService;
    }
    @PostMapping("SetKey")
    public ResponseEntity<public_keys_Entity> setKey() {
        public_keys_Entity key = keysService.SetKey();
        return new ResponseEntity<>(key, HttpStatus.CREATED);
    }
}

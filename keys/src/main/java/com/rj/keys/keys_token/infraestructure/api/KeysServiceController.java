package com.rj.keys.keys_token.infraestructure.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rj.keys.keys_token.domain.model.private_key_Entity;
import com.rj.keys.keys_token.domain.model.public_keys_Entity;
import com.rj.keys.keys_token.domain.service.Keys_Service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/security/keys")
public class KeysServiceController {
    private final Keys_Service keysService;
    public KeysServiceController(Keys_Service keysService) {
        this.keysService = keysService;
    }
    @GetMapping("getPublicKeys")
    public ResponseEntity<List<public_keys_Entity>> getPublicKeys() {
        List<public_keys_Entity> keys = keysService.getPublicKeys();
        return new ResponseEntity<>(keys, HttpStatus.FOUND);
    }
    @GetMapping("getPrivateKey")
    public ResponseEntity<private_key_Entity> getPrivateKey() {
        private_key_Entity key = keysService.getPrivateKey();
        return new ResponseEntity<>(key, HttpStatus.FOUND);
    }
}

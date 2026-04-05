package com.rj.keys.key_pass.infraestructure.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rj.keys.key_pass.domain.model.keys_pass_Entity;
import com.rj.keys.key_pass.domain.service.Keys_Pass_Service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/security/passkeys")
public class KeysPassServiceController {
    private final Keys_Pass_Service keysService;
    public KeysPassServiceController(Keys_Pass_Service keysService) {
        this.keysService = keysService;
    }
    @PostMapping("getPassKeys")
    public ResponseEntity<List<keys_pass_Entity>> getPassKeys() {
        List<keys_pass_Entity> keys = keysService.getPassKeys();
        return new ResponseEntity<>(keys, HttpStatus.CREATED);
    }
}

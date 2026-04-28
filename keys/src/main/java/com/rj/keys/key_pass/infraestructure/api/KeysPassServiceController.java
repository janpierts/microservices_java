package com.rj.keys.key_pass.infraestructure.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rj.keys.key_pass.application.service.Keys_Pass_Service;
import com.rj.keys.key_pass.domain.keys_pass_Entity;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/security/passkeys")
public class KeysPassServiceController {
    private final Keys_Pass_Service keysService;
    public KeysPassServiceController(Keys_Pass_Service keysService) {
        this.keysService = keysService;
    }
    @GetMapping("getPassKeys")
    public ResponseEntity<List<keys_pass_Entity>> getPassKeys() {
        List<keys_pass_Entity> keys = keysService.getPassKeys();
        return new ResponseEntity<>(keys, HttpStatus.FOUND);
    }
}

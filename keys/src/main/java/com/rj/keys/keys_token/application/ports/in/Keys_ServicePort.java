package com.rj.keys.keys_token.application.ports.in;

import java.util.List;

import com.rj.keys.keys_token.domain.private_key_Entity;
import com.rj.keys.keys_token.domain.public_keys_Entity;

public interface Keys_ServicePort {
    List<public_keys_Entity> getPublicKeys();
    private_key_Entity getPrivateKey();
}

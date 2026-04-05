package com.rj.keys.keys_token.domain.ports.in;

import java.util.List;
import com.rj.keys.keys_token.domain.model.private_key_Entity;
import com.rj.keys.keys_token.domain.model.public_keys_Entity;

public interface Keys_ServicePort {
    List<public_keys_Entity> getPublicKeys();
    private_key_Entity getPrivateKey();
}

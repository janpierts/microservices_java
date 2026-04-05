package com.rj.keys.keys_token.domain.ports.out;

import java.util.List;
import com.rj.keys.keys_token.domain.model.private_key_Entity;
import com.rj.keys.keys_token.domain.model.public_keys_Entity;

public interface Keys_RepositoryPort {
    List<public_keys_Entity> getPublicKeys();
    private_key_Entity getPrivateKey();
}

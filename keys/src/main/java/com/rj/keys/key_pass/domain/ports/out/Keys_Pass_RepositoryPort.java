package com.rj.keys.key_pass.domain.ports.out;

import java.util.List;
import com.rj.keys.key_pass.domain.model.keys_pass_Entity;

public interface Keys_Pass_RepositoryPort {
    List<keys_pass_Entity> getPassKeys();
}

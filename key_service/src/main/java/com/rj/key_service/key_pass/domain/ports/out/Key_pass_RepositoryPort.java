package com.rj.key_service.key_pass.domain.ports.out;

import com.rj.key_service.key_pass.domain.model.key_pass_Entity;
import com.rj.key_service.key_pass.domain.model.key_pass_request_Entity;

public interface Key_pass_RepositoryPort {
    key_pass_Entity SetPassKeyWord(key_pass_request_Entity request);
}

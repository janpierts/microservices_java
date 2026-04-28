package com.rj.key_service.key_pass.application.ports.in;

import com.rj.key_service.key_pass.domain.key_pass_Entity;
import com.rj.key_service.key_pass.domain.key_pass_request_Entity;

public interface Key_pass_ServicePort {
    key_pass_Entity SetPassKeyWord(key_pass_request_Entity request);
}

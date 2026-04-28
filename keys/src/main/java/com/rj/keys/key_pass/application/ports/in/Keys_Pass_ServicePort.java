package com.rj.keys.key_pass.application.ports.in;

import java.util.List;

import com.rj.keys.key_pass.domain.keys_pass_Entity;

public interface Keys_Pass_ServicePort {
    List<keys_pass_Entity> getPassKeys();
}

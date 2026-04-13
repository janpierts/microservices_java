package com.rj.auth.login.domain.ports.in;

import com.rj.auth.login.domain.model.Login_request_Entity;
import com.rj.auth.login.domain.model.Login_user_Entity;

public interface Login_ServicePort {
    Login_user_Entity login(Login_request_Entity entity);
}

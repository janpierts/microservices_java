package com.rj.auth.login.application.ports.in;

import com.rj.auth.login.domain.Login_request_Entity;
import com.rj.auth.login.domain.Login_user_Entity;

public interface Login_ServicePort {
    Login_user_Entity login(Login_request_Entity entity);
}

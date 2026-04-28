package com.rj.auth.login.application.ports.out;

import com.rj.auth.login.domain.Login_request_Entity;
import com.rj.auth.login.domain.Login_user_Entity;

public interface Login_RepositoryPort {
    Login_user_Entity login(Login_request_Entity entity);

}

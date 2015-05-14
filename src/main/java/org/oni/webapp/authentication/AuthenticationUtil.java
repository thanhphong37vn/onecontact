
package org.oni.webapp.authentication;

import org.springframework.security.core.context.SecurityContextHolder;


public class AuthenticationUtil {


    public static LoginUserInfo getLoginUserInfo() {

        LoginUserInfo loginUser
                = (LoginUserInfo) SecurityContextHolder.getContext()
                        .getAuthentication().getPrincipal();
        return loginUser;
    }
}

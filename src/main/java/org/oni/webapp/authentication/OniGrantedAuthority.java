package org.oni.webapp.authentication;

import org.springframework.security.core.GrantedAuthority;

/**
 * It is an enumeration representing the user privileges for authentication.
 * @author DungTV
 */
public enum OniGrantedAuthority implements GrantedAuthority {

    /** Administrator */
    ADMIN,
    /** User */
    USER;

    
    public String getAuthority() {
        return "ROLE_" + toString();
    }
    
}

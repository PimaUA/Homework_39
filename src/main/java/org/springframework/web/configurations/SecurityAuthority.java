package org.springframework.web.configurations;

import org.springframework.security.core.GrantedAuthority;

public class SecurityAuthority implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return null;
    }
}

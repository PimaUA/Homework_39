package org.springframework.web.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;


public class MyUserPrincipal implements UserDetails {
    private final User user;
    @Autowired
    private PasswordEncoder encoder;

    public MyUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*Set<Role>roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;*/
        Set<Role>roles=user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role:roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
}

return authorities;
    }


   /* @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return Collections.singleton(authority);
    }*/

    @Override
    public String getPassword() {
       String encoded = new BCryptPasswordEncoder().encode(user.getPassword());
       return encoded;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

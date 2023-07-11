package org.springframework.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.entities.MyUserPrincipal;
import org.springframework.web.entities.User;
import org.springframework.web.repository.UserRepository;

import java.util.Optional;

@Service
//@Component
//@Scope("prototype")
public class DatabaseUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      /*  User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);*/


       /* return userRepository
                .findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));*/
        //}

        Optional<User> user = userRepository.findByUsername(username);

        return user.map(MyUserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("USER_NOT_FOUND_MSG ", username)));
    }
}
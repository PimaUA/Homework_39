package org.springframework.web.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.service.DatabaseUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
    @Autowired
   DatabaseUserDetailsService databaseUserDetailsService;

   /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .securityMatcher("/deleteProduct/{id}","/addProduct")
                .authorizeHttpRequests(authorize -> authorize
                                .anyRequest().hasRole("ADMIN")
                        *//*.requestMatchers("/").permitAll()
                        .requestMatchers("/products/{id}","/products").hasAnyRole("ADMIN","USER")
                        .requestMatchers("/deleteProduct/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated()*//*
                )
                .formLogin(withDefaults())
                *//*.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/products/{id}","/products")
                        .hasAnyRole("ADMIN","USER")
                        .requestMatchers("/addProduct").hasRole("ADMIN")
                        .requestMatchers("/deleteProduct/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )*//*
                *//*.formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())//.httpBasic();*//*
                .httpBasic(withDefaults());
        return http.build();
    }*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //.securityMatcher("/deleteProduct/{id}","/addProduct")
                .authorizeHttpRequests(authorize -> authorize
                        //.requestMatchers("/").permitAll()
                        .requestMatchers("/hello/products/{id}","/hello/products")
                        .hasAnyRole("USER","ADMIN")
                        .requestMatchers("/hello/deleteProduct/{id}","/hello/addProduct")
                        .hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .httpBasic(withDefaults());
        return http.build();
    }



    /*@Bean
    @Order(1)
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/deleteProduct/{id}","/addProduct")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().hasRole("ADMIN")
                )
                .httpBasic(withDefaults());
        return http.build();
    }*/

  /*  @Bean
    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults());
        return http.build();
    }*/

   /* @Bean
    public DatabaseUserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService(passwordEncoder());
    }*/


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

   /* @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }*/
}

package com.smelgert.broker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .anyRequest().authenticated()  // Require authentication for all requests
                )
                    .formLogin(Customizer.withDefaults())  // Enable form-based login using default configurations
                .httpBasic(Customizer.withDefaults());  // Enable HTTP Basic Authentication using default configurations

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))  // Encode the password
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);  // Return an in-memory user details manager
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
    }
}
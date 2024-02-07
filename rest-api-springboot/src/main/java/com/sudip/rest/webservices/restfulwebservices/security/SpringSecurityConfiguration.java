package com.sudip.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 */
public class SpringSecurityConfiguration {

    /**
     * Configures the security filter chain.
     *
     * @param http the HttpSecurity object to configure
     * @return the SecurityFilterChain object representing the security filter chain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Enabling Security on frontend part
        //1. Response to preflight request doesn't pass access control check
        //2. Basic auth

        /* Steps to perform Security configuration:
         * 1.All requests should be authenticated
         * 2.If a request is not authenticated, a web page is shown
         * 3. CSRF -> POT, PUT
         * */

        // 1.All requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Basic auth step
                        .anyRequest().authenticated()
        );

        // 2.If a request is not authenticated, a web page is shown
        http.httpBasic(Customizer.withDefaults());

        // 3. CSRF -> POT, PUT Disable CSRF
        http.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf().disable();

        return http.build();
    }
}

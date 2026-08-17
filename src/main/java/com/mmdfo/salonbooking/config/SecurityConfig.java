package com.mmdfo.salonbooking.config;

import com.mmdfo.salonbooking.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            JwtAuthenticationFilter jwtAuthenticationFilter
    ) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(
                                        "/api/auth/**",
                                        "/swagger-ui/**",
                                        "/swagger-ui.html",
                                        "/v3/api-docs/**"
                                ).permitAll()

                                .requestMatchers("/api/customer/**")
                                .hasRole("CUSTOMER")

                                .requestMatchers("/api/employee/**")
                                .hasAnyRole("EMPLOYEE", "ADMIN")

                                .requestMatchers("/api/admin/**")
                                .hasRole("ADMIN")
                                .requestMatchers("/api/test/authenticated")
                                .hasAnyRole("CUSTOMER", "EMPLOYEE", "ADMIN")

                                .requestMatchers("/api/test/customer")
                                .hasRole("CUSTOMER")

                                .requestMatchers("/api/test/employee")
                                .hasAnyRole("EMPLOYEE", "ADMIN")

                                .requestMatchers("/api/test/admin")
                                .hasRole("ADMIN")
                                .anyRequest().authenticated()
                )

                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}
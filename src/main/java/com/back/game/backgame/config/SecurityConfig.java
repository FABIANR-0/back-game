package com.back.game.backgame.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import java.util.HashMap;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


    private final String[] ROUTES_ALLOWED_WITHOUT_AUTHENTICATION = {
            "auth/login",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/**"
    };

    private final String[] ROUTES_GET_ALLOWED_WITHOUT_AUTHENTICATION = {};

    private final String[] ROUTES_POST_ALLOWED_WITHOUT_AUTHENTICATION = {};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, CorsConfig corsConfig) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfig.corsConfigurationSource()))
                .sessionManagement(sessionManagementConfig -> sessionManagementConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers(ROUTES_ALLOWED_WITHOUT_AUTHENTICATION).permitAll();
                    registry.requestMatchers(HttpMethod.GET, ROUTES_GET_ALLOWED_WITHOUT_AUTHENTICATION).permitAll();
                    registry.requestMatchers(HttpMethod.POST, ROUTES_POST_ALLOWED_WITHOUT_AUTHENTICATION).permitAll();
                    registry.anyRequest().authenticated();
                }).exceptionHandling(httpSecurityExceptionHandlingConfigurer -> {
                    httpSecurityExceptionHandlingConfigurer.accessDeniedHandler((request, response, accessDeniedException) -> {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("message", "No tienes credenciales para acceder a este recurso.");
                        ObjectMapper mapper = new ObjectMapper();
                        response.setStatus(403);
                        response.setHeader("Content-Type", "application/json");
                        response.addHeader("message", "forbidden");
                        mapper.writeValueAsString(map);
                        response.getWriter().write(mapper.writeValueAsString(map));
                    }).authenticationEntryPoint((request, response, authException) -> {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("message", "Credenciales inválidas. Inicia sesión con un usuario autorizado");
                        ObjectMapper mapper = new ObjectMapper();
                        response.setStatus(401);
                        response.setHeader("Content-Type", "application/json");
                        response.getWriter().write(mapper.writeValueAsString(map));
                    });
                });
        return httpSecurity.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowBackSlash(true);
        return (web -> web.httpFirewall(firewall));
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
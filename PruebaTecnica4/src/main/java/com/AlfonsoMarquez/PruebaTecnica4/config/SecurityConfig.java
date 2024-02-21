package com.AlfonsoMarquez.PruebaTecnica4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;





@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests()
                // Permitir acceso sin autenticación a estas rutas
                .requestMatchers("/agency/hotel-booking/new", "/agency/flight-booking/new").permitAll()
                // Permitir acceso sin autenticación a los métodos GET
                .requestMatchers(HttpMethod.GET, "/**").permitAll()
                // Requerir autenticación para el resto de las rutas
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll() // Permitir acceso al formulario de login
                .and()
                .build();
    }

}
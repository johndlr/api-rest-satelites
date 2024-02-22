package com.auroracode.springboot.satelitesRestApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //Definiendo la consulta para que spring sepa el username
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM miembros WHERE user_id=?");

        //Definiendo la consulta para que spring sepa los roles
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");
        return jdbcUserDetailsManager;
    }

    //Configurando los accesos de acuerdo a los roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests( configurer -> configurer
                .requestMatchers(HttpMethod.GET, "/api/satelites").hasRole("USUARIO")
                .requestMatchers(HttpMethod.GET, "/api/satelites/**").hasRole("USUARIO")
                .requestMatchers(HttpMethod.POST, "/api/satelites").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/satelites").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/satelites/**").hasRole("ADMIN")
        );

        //use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable CSRF. Solo se usa con formularios, en caso de API REST se recomienda desactivarlo
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();

    }

}

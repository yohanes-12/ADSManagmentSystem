package com.ads.adsmanagment.config;

import com.ads.adsmanagment.filter.JWTAuthFilter;
import com.ads.adsmanagment.service.imp.AdsUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ADSWebAPISecurityConfig {

    private AdsUserDetailsService adsUserDetailsService;
    private JWTAuthFilter jwtAuthFilter;

    public ADSWebAPISecurityConfig(AdsUserDetailsService adsUserDetailsService, JWTAuthFilter jwtAuthFilter) {
        this.adsUserDetailsService = adsUserDetailsService;
        this.jwtAuthFilter = jwtAuthFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AdsUserDetailsService::disable)
                .authorizeHttpRequests(
                        auth -> {
                            auth
                                    .requestMatchers("/adsweb/api/v1/patient").permitAll();
////                                    .requestMatchers("/adsweb/api/v1/patient/auth/**").permitAll()
////                                    .requestMatchers("/adsweb/api/v1/patient**").authenticated()
////                                    .requestMatchers("/adsweb/api/v1/patient/get/**").authenticated()
////                                    .requestMatchers("/adsweb/api/v1/patient/update/**").authenticated()
////                                    .requestMatchers("/adsweb/api/v1/patient/delete/**").authenticated()
////                                    .requestMatchers("/adsweb/api/v1/patient/register").authenticated()
////                                    .requestMatchers("/adsweb/api/v1/patient/list").authenticated()
////                                    .requestMatchers("/adsweb/api/v1/address").permitAll()
//                                    .requestMatchers("/adsweb/api/v1**").authenticated();
                        }
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(adsUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}




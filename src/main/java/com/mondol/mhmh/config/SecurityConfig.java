package com.mondol.mhmh.config;

import com.mondol.mhmh.auth.oAuth.CustomAuthExceptionHandler;
import com.mondol.mhmh.auth.oAuth.CustomOAuth2SuccessHandler;
import com.mondol.mhmh.auth.oAuth.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomOAuth2SuccessHandler customOAuth2SuccessHandler;
    private final CustomAuthExceptionHandler customAuthExceptionHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.print("이곳은 red");
        http.authorizeHttpRequests(authorize -> authorize
                .anyRequest().authenticated());
        http.oauth2Login(config -> config
                .successHandler(customOAuth2SuccessHandler)
//                .failureHandler(customAuthExceptionHandler)
                .userInfoEndpoint(endpointConfig -> endpointConfig
                        .userService(customOAuth2UserService)));

        return http.build();
    }

}
package com.social.project.demo.security.config;

import com.social.project.demo.security.filter.JwtAuthenticationFilter;
import com.social.project.demo.security.filter.JwtAuthorizationFilter;
import com.social.project.demo.security.util.JwtTokenGenerator;
import com.social.project.demo.security.util.JwtTokenProvider;
import com.social.project.demo.security.util.UserDetailsExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfigurer {

    private final JwtTokenGenerator jwtTokenGenerator;
    private final UserDetailsExtractor userDetailsExtractor;
    private final AuthenticationEntryPoint authenticationEntryPoint;


    @Autowired
    void configureAuthenticationManager(
            AuthenticationManagerBuilder auth,
            JwtTokenProvider jwtTokenProvider
    ) {
        auth.authenticationProvider(jwtTokenProvider);
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        var authenticationManager = authenticationManager(http.getSharedObject(AuthenticationConfiguration.class));

        http.csrf(c -> c.disable())
                .authorizeHttpRequests(c -> {
                    c.requestMatchers("/login", "/api/users/register", "/swagger-ui/**").permitAll();
                    c.anyRequest().authenticated();
                })
                .addFilter(new JwtAuthenticationFilter(authenticationManager, jwtTokenGenerator))
                .addFilterAfter(new JwtAuthorizationFilter(userDetailsExtractor), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(c -> {
                    c.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                });

        http.exceptionHandling(c -> c
                .authenticationEntryPoint(authenticationEntryPoint));
//                .accessDeniedHandler(accessDeniedHandler));

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/swagger-ui/**"
        );
    }


}

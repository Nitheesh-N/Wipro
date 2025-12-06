package com.playstore.owner.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()
                    .requestMatchers("/", "/owner/**",
                                     "/api/owners/register",
                                     "/api/owners/login",
                                     "/h2-console/**").permitAll()
                  
                    .requestMatchers(HttpMethod.GET, "/api/owners/apps/public/**", "/api/owners/apps/*").permitAll()

                    
                    .requestMatchers(HttpMethod.POST, "/api/owners/apps/*/rating").permitAll()

                    
                    .requestMatchers(HttpMethod.POST, "/api/owners/apps/*/download").permitAll()

                    
                    .requestMatchers(HttpMethod.POST, "/api/owners/apps/**").authenticated()
                    .requestMatchers(HttpMethod.PATCH, "/api/owners/apps/**").authenticated()
                    .requestMatchers(HttpMethod.PUT, "/api/owners/apps/**").authenticated()
                    .requestMatchers(HttpMethod.DELETE, "/api/owners/apps/**").authenticated()

                    .requestMatchers(HttpMethod.GET, "/api/owners/notifications/**").authenticated()
                    .requestMatchers(HttpMethod.POST, "/api/owners/announcements").authenticated()
                    .requestMatchers(HttpMethod.GET, "/api/owners/announcements/**").permitAll()
                    .anyRequest().authenticated()
            )



            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

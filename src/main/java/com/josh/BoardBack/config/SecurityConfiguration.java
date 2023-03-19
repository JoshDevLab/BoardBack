package com.josh.BoardBack.config;

import com.josh.BoardBack.auth.AuthenticationController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/v1/auth/**")
            .permitAll() // 위의 url들을 허용한다는 메소드
            .anyRequest() // 그 외의 다른 경로들은
            .authenticated() // 인증이 필요하다는 메소드
            .and()
            .sessionManagement() // 세션매니지먼트를
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 무상태로 유지한다. 한마디로 jwt 쓰겠다는말
            .and()
            .authenticationProvider(authenticationProvider) // 인증절차를 정의하는 것
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
            // jwtAuthFilter 를  UsernamePasswordAuthenticationFilter 보다 먼저 실행한다.

        return http.build();
    }
}

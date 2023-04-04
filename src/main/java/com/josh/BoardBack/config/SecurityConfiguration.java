package com.josh.BoardBack.config;

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
@EnableWebSecurity // Spring Security를 사용하도록 활성화
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // HTTP 요청을 처리할 Spring Security 필터들의 체인
        http
            .csrf()
            .disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/v1/auth/**")
            .permitAll() // 위의 url 들을 허용한다는 메소드
            .anyRequest() // 그 외의 다른 경로들은
            .authenticated() // 인증이 필요하다는 메소드
            .and()
            .sessionManagement() // 세션매니지먼트를
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 무상태로 유지한다. 한마디로 jwt 쓰겠다는말
            .and()
            .authenticationProvider(authenticationProvider) // 인증절차를 정의하는 것
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
            // jwtAuthFilter 를  UsernamePasswordAuthenticationFilter 보다 먼저 실행한다.
            // 이렇게 함으로써 JWT 인증 필터가 우선적으로 실행되어 JWT 인증 정보를 처리할 수 있음

        return http.build();
    }
}

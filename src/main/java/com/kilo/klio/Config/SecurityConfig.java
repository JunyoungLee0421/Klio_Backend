package com.kilo.klio.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (필요 시 활성화)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/hellotwo", "/api/auth/signup", "/api/auth/login").permitAll() // 인증 없이 허용
                .anyRequest().authenticated() // 나머지 요청은 인증 필요
            )
            .httpBasic(httpBasic -> httpBasic.disable()) // HTTP Basic 비활성화
            .formLogin(formLogin -> formLogin.disable()); // 기본 로그인 폼 비활성화

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 비밀번호 해싱을 위한 인코더
    }
}

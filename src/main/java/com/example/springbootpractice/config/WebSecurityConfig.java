package com.example.springbootpractice.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request       //
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()     // 기본값은 Forword 방식으로 이동시도 모두 로그인 페이지로 이동
                        .requestMatchers("/register").permitAll()   //로그인 없이도 접근할 수 있는 페이지 설정
                        .anyRequest().authenticated()           // 어떠한 요청이라도 인증요구
                )
                .formLogin(login -> login                       // form 방식의 로그인 일 경우
                        .loginPage("/login")                    // Mapping 된 loginPage
                        .loginProcessingUrl("/login")           // loginPage에서의 Action
                        .usernameParameter("userName")          // username의 name 값
                        .passwordParameter("password")          // password의 name 값
                        .defaultSuccessUrl("/index2", true) // 로그인 성공시 이동할 Mapping
                        .permitAll()                            // 대시보드 이동이 막히면 안되므로 얘는 허용 ????
                )
                .logout(withDefaults());                        // 로그아웃을 실행하는 Mapping (Default: /logout)

        return http.build();
    }
}
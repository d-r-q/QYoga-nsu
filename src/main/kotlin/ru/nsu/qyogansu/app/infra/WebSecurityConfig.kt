package ru.nsu.qyogansu.app.infra

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class WebSecurityConfig {

    @Bean
    fun mainSecurityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .csrf { it.disable() }
                .authorizeHttpRequests { requests ->
                    requests
                            .requestMatchers(HttpMethod.POST, "/login", "/register", "/error-p").permitAll()
                            .requestMatchers("/error").permitAll()

                            .requestMatchers("/**").denyAll()

                            .anyRequest().authenticated()
                }
                .formLogin { form ->
                    form
                            .loginPage("/login")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/error-p")
                            .permitAll()
                }
                .logout { logout -> logout.permitAll() }
        return http.build()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

}
package com.npe.kotlin_springboot_base.api.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
class SecurityConfiguration() {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests {
                it.anyRequest().permitAll()
//                it.requestMatchers(AntPathRequestMatcher("/mock/**")).permitAll()
//                it.requestMatchers(AntPathRequestMatcher("/actuator/**")).permitAll()
//                it.anyRequest().authenticated()
            }
            .formLogin {
                it.permitAll()
            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            }.csrf {
                it.disable()
            }

        return http.build()
    }
}
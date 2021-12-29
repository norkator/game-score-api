package com.nitramite.gamescoreapi.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
class SecurityConfig(
    private val authProvider: CustomAuthenticationProvider
) : WebSecurityConfigurerAdapter() {

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authProvider)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/games/**").permitAll()
            .antMatchers(HttpMethod.GET, "/games/**").permitAll()
            .antMatchers(HttpMethod.PATCH, "/games/**").permitAll()
            .antMatchers(HttpMethod.PUT, "/games/**").permitAll()
            .antMatchers(HttpMethod.POST, "/achievements/achievementType").permitAll()
            .and()
            .csrf().disable()
            .formLogin().disable()
    }

}
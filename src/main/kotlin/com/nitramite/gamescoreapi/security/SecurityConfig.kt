package com.nitramite.gamescoreapi.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter(){

    @Value("\${basic_auth.username}")
    private val basicAuthUsername: String? = null

    @Value("\${basic_auth.password}")
    private val basicAuthPassword: String? = null

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser(basicAuthUsername)
            .password(encoder().encode(basicAuthPassword))
            .roles("USER", "ADMIN")
            // .and()
            // .withUser("user")
            // .password(encoder().encode("pass"))
            // .roles("USER")
    }

    // @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.httpBasic()
            .and()
            .authorizeRequests()
            // .antMatchers(HttpMethod.GET, "/tasks").hasRole("ADMIN")
            // .antMatchers(HttpMethod.POST, "/tasks/**").hasRole("ADMIN")
            // .antMatchers(HttpMethod.PUT, "/tasks/**").hasRole("ADMIN")
            // .antMatchers(HttpMethod.DELETE, "/tasks/**").hasRole("ADMIN")
            // .antMatchers(HttpMethod.GET, "/tasks/**").hasAnyRole("ADMIN", "USER")
            .antMatchers("./").permitAll()
            .and()
            .csrf().disable()
            .formLogin().disable()
    }

}
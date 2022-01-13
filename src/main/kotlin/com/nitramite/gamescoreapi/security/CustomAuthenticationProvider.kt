package com.nitramite.gamescoreapi.security

import com.nitramite.gamescoreapi.model.User
import com.nitramite.gamescoreapi.service.PasswordService
import com.nitramite.gamescoreapi.service.UserService
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import java.util.*

@Component
class CustomAuthenticationProvider(
    private val userService: UserService,
    private val passwordService: PasswordService,
) : AuthenticationProvider {

    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication? {
        val username: String = authentication.name
        val password: String = authentication.credentials.toString();

        val user: User = userService.findUserByUsername(username) ?: return null

        // validate password matches
        if (!passwordService.checkPassword(password, user.password)) {
            return null
        }

        val authorities: MutableList<GrantedAuthority> = ArrayList()
        authorities.add(SimpleGrantedAuthority(user.role))

        return UsernamePasswordAuthenticationToken(username, password, authorities)
    }

    override fun supports(authentication: Class<*>): Boolean {
        return authentication == UsernamePasswordAuthenticationToken::class.java
    }

}
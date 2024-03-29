package com.nitramite.gamescoreapi.service

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class PasswordService {

    private val strength = 10;

    fun encodedPassword(plainPassword: String): String {
        val bCryptPasswordEncoder = BCryptPasswordEncoder(strength)
        return bCryptPasswordEncoder.encode(plainPassword)
    }

    fun checkPassword(plainPassword: String, encodedPassword: String): Boolean {
        val bCryptPasswordEncoder = BCryptPasswordEncoder(strength)
        return bCryptPasswordEncoder.matches(plainPassword, encodedPassword);
    }

}
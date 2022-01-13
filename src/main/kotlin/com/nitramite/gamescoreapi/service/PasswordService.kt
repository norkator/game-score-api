package com.nitramite.gamescoreapi.service

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.security.SecureRandom

@Service
class PasswordService {

    fun encodedPassword(plainPassword: String): String {
        val strength = 10
        val bCryptPasswordEncoder = BCryptPasswordEncoder(strength, SecureRandom())
        return bCryptPasswordEncoder.encode(plainPassword)
    }

}
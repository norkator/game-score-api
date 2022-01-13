package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.service.PasswordService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/password")
class PasswordController(
    private val passwordService: PasswordService
) {

    @GetMapping("/encoded")
    fun getPassword(@RequestParam plaintext: String): String {
        return passwordService.encodedPassword(plaintext)
    }

}
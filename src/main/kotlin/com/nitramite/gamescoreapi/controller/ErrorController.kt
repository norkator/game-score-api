package com.nitramite.gamescoreapi.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ErrorController {

    @RequestMapping("/")
    fun defaultRoutes(): String {
        return "Resource not available"
    }

}
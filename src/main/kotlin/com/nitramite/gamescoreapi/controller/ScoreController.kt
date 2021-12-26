package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.model.Score
import com.nitramite.gamescoreapi.service.ScoreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/score")
class ScoreController(
    private val scoreService: ScoreService,
) {

    @GetMapping("/score")
    fun getScore(@RequestParam name: String): Score? {
        return scoreService.getScoreByName(name)
    }

}
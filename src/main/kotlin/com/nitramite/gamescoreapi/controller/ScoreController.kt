package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.model.Score
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/score")
class ScoreController {

    @GetMapping("/score")
    fun getScore(@RequestParam name: String): Score {

        val score = Score()
        score.name = "testing"
        score.score = 100

        return score
    }

}
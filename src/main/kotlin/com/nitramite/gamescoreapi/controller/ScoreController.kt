package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.model.Score
import com.nitramite.gamescoreapi.service.ScoreService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scores")
class ScoreController(
    private val scoreService: ScoreService,
) {

    @GetMapping("/score")
    fun getScore(@RequestParam gameId: Long, @RequestParam clientUid: String): Score? {
        return scoreService.getScoreByGameIdAndClientUid(gameId, clientUid)
    }

    @PostMapping("/score")
    fun postScore(@RequestBody score: Score): Score? {
        return scoreService.addScore(score.gameId, score.clientUid, score.score)
    }

}
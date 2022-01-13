package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.model.Score
import com.nitramite.gamescoreapi.service.ScoreService
import org.springframework.web.bind.annotation.*
import java.util.ArrayList

@RestController
@RequestMapping("/scores")
class ScoreController(
    private val scoreService: ScoreService,
) {

    @GetMapping("/score")
    fun getScore(@RequestParam gameId: Long, @RequestParam clientUid: String): Score? {
        return scoreService.getScoreByGameIdAndClientUid(gameId, clientUid)
    }

    @GetMapping("/bestByGame")
    fun getBestScoresByGame(@RequestParam gameId: Long): List<Score> {
        return scoreService.getBestScoresByGameId(gameId)
    }

    @PostMapping("/score")
    fun postScore(@RequestBody score: Score): Score? {
        return scoreService.addScore(score.gameId, score.clientUid, score.score)
    }

    @GetMapping("/forClient")
    fun getScoresForClient(@RequestParam clientUid: String, @RequestParam gameIds: List<Long>): ArrayList<Score>? {
        return scoreService.getScoresForClient(clientUid, gameIds)
    }

}
package com.nitramite.gamescoreapi.service

import com.nitramite.gamescoreapi.dao.ScoreEntity
import com.nitramite.gamescoreapi.model.Score
import com.nitramite.gamescoreapi.repository.ScoreRepository
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

@Service
class ScoreService(private val scoreRepository: ScoreRepository) {

    fun addScore(gameId: Long, clientUid: String, score: Long): Score {
        val newScore = ScoreEntity(null, gameId, clientUid, score)
        newScore.createdAt = Instant.now()
        newScore.updatedAt = Instant.now()
        scoreRepository.save(newScore)
        return Score.fromDao(newScore)
    }

    fun getScoreById(id: Long): Score? {
        val score: Optional<ScoreEntity> = scoreRepository.findById(id)
        return if (score.isPresent) Score.fromDao(score.get()) else null
    }

    fun getScoreByGameIdAndClientUid(gameId: Long, gameUid: String): Score? {
        val score: Optional<ScoreEntity> = scoreRepository.findAllByGameIdAndClientUid(gameId, gameUid)
        return if (score.isPresent) Score.fromDao(score.get()) else null
    }

}
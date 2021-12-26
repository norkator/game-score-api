package com.nitramite.gamescoreapi.service

import com.nitramite.gamescoreapi.dao.ScoreEntity
import com.nitramite.gamescoreapi.model.Score
import com.nitramite.gamescoreapi.repository.ScoreRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ScoreService(private val scoreRepository: ScoreRepository) {

    fun addScore(name: String, score: Long): Score {
        val newScore: ScoreEntity = ScoreEntity(null, name, score)
        scoreRepository.save(newScore)
        return Score.fromDao(newScore)
    }

    fun getScoreById(id: Long): Score? {
        val score: Optional<ScoreEntity> = scoreRepository.findById(id)
        return if (score.isPresent) Score.fromDao(score.get()) else null
    }

}
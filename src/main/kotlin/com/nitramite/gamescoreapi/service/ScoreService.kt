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
        val scoreEntity = scoreRepository.findTopByGameIdAndClientUid(gameId, clientUid);
        if (!scoreEntity.isPresent) {
            val newScore = ScoreEntity(null, gameId, clientUid, score)
            newScore.createdAt = Instant.now()
            newScore.updatedAt = Instant.now()
            scoreRepository.save(newScore)
            return Score.fromDao(newScore)
        } else {
            val existing = scoreEntity.get()
            if (score > existing.score) {
                existing.score = score
                scoreRepository.save(existing)
            }
            return Score.fromDao(existing)
        }
    }

    fun getScoreById(id: Long): Score? {
        val score: Optional<ScoreEntity> = scoreRepository.findById(id)
        return if (score.isPresent) Score.fromDao(score.get()) else null
    }

    fun getScoreByGameIdAndClientUid(gameId: Long, gameUid: String): Score? {
        val score: Optional<ScoreEntity> = scoreRepository.findAllByGameIdAndClientUid(gameId, gameUid)
        return if (score.isPresent) Score.fromDao(score.get()) else null
    }

    fun getBestScoresByGameId(gameId: Long): ArrayList<Score> {
        val scoreEntities: List<ScoreEntity> = scoreRepository.findAllByGameIdOrderByScoreDesc(gameId)
        val scores: ArrayList<Score> = ArrayList()
        scoreEntities.forEach {
            scores.add(Score.fromDao(it))
        }
        return scores
    }

    fun getScoresForClient(clientUid: String, gameIds: List<Long>): ArrayList<Score>? {
        val scoreEntities: Optional<List<ScoreEntity>> = scoreRepository.findAllByGameIdInAndClientUid(gameIds, clientUid)
        val scores: ArrayList<Score> = ArrayList()
        return if (scoreEntities.isPresent) {
            scoreEntities.get().forEach {
                scores.add(Score.fromDao(it))
            }
            scores
        } else {
            null
        }
    }

}
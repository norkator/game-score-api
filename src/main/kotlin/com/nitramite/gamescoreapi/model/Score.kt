package com.nitramite.gamescoreapi.model

import com.nitramite.gamescoreapi.dao.ScoreEntity
import java.time.Instant

class Score(
    val id: Long = 0,
    val gameId: Long,
    var clientUid: String,
    var score: Long = 0,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
) {
    companion object {
        fun fromDao(scoreEntity: ScoreEntity) = Score(
            scoreEntity.id!!,
            scoreEntity.gameId,
            scoreEntity.clientUid,
            scoreEntity.score,
            scoreEntity.createdAt,
            scoreEntity.updatedAt
        )
    }
}
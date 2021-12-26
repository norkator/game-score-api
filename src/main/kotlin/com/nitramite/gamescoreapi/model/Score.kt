package com.nitramite.gamescoreapi.model

import com.nitramite.gamescoreapi.dao.ScoreEntity

class Score(
    val id: Long = 0,
    var name: String? = null,
    var score: Long = 0,
) {
    companion object {
        fun fromDao(scoreEntity: ScoreEntity) = Score(
            scoreEntity.id!!,
            scoreEntity.name,
            scoreEntity.score
        )
    }
}
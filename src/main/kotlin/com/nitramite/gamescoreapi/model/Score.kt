package com.nitramite.gamescoreapi.model

import com.nitramite.gamescoreapi.dao.ScoreEntity

class Score(
    val id: Int = 0,
    var name: String? = null,
    var score: Int = 0,
) {
    fun fromDao(scoreEntity: ScoreEntity) = Score(
        scoreEntity.id,
        scoreEntity.name,
        scoreEntity.score
    )
}
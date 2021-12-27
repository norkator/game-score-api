package com.nitramite.gamescoreapi.model

import com.nitramite.gamescoreapi.dao.GameEntity
import java.time.Instant

class Game(
    val id: Long = 0,
    var name: String? = null,
    var description: String? = null,
    var enabled: Boolean = true
) {
    companion object {
        fun fromDao(gameEntity: GameEntity) = Game(
            gameEntity.id!!,
            gameEntity.name,
            gameEntity.description,
            gameEntity.enabled
        )
    }
}
package com.nitramite.gamescoreapi.model

import com.nitramite.gamescoreapi.dao.GameEntity

class Game(
    val id: Long = 0,
    var name: String,
    var description: String? = null,
    var enabled: Boolean = true,
    var userId: Long
) {
    companion object {
        fun fromDao(gameEntity: GameEntity) = Game(
            gameEntity.id!!,
            gameEntity.name,
            gameEntity.description,
            gameEntity.enabled,
            gameEntity.userId,
        )
    }
}
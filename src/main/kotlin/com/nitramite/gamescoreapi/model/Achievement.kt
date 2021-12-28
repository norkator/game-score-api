package com.nitramite.gamescoreapi.model

import com.nitramite.gamescoreapi.dao.AchievementEntity
import java.time.Instant

class Achievement(
    val id: Long,
    val gameId: Long,
    val clientUid: String,
    val achievementTypeId: Long,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
) {
    companion object {
        fun fromDao(achievementEntity: AchievementEntity) = Achievement(
            achievementEntity.id!!,
            achievementEntity.gameId,
            achievementEntity.clientUid,
            achievementEntity.achievementTypeId,
            achievementEntity.createdAt,
            achievementEntity.updatedAt,
        )
    }
}
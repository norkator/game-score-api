package com.nitramite.gamescoreapi.model

import com.nitramite.gamescoreapi.dao.AchievementTypeEntity

class AchievementType(
    val id: Long,
    val name: String,
    val description: String
) {
    companion object {
        fun fromDao(achievementTypeEntity: AchievementTypeEntity) = AchievementType(
            achievementTypeEntity.id!!,
            achievementTypeEntity.name,
            achievementTypeEntity.description
        )
    }
}
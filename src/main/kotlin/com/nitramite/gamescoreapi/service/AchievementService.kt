package com.nitramite.gamescoreapi.service

import com.nitramite.gamescoreapi.dao.AchievementEntity
import com.nitramite.gamescoreapi.dao.AchievementTypeEntity
import com.nitramite.gamescoreapi.model.Achievement
import com.nitramite.gamescoreapi.model.AchievementType
import com.nitramite.gamescoreapi.repository.AchievementRepository
import com.nitramite.gamescoreapi.repository.AchievementTypeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AchievementService(
    private val achievementRepository: AchievementRepository,
    private val achievementTypeRepository: AchievementTypeRepository
) {

    fun addAchievementType(gameId: Long, name: String, decsription: String): AchievementType {
        val newAchievementType = AchievementTypeEntity(null, gameId, name, decsription)
        achievementTypeRepository.save(newAchievementType)
        return AchievementType.fromDao(newAchievementType)
    }

    fun addAchievement(gameId: Long, clientUid: String, achievementTypeId: Long): Achievement {
        val newAchievement = AchievementEntity(null, gameId, clientUid, achievementTypeId)
        achievementRepository.save(newAchievement)
        return Achievement.fromDao(newAchievement)
    }

    fun getAchievementsByGameId(gameId: Long): ArrayList<Achievement> {
        val achievementEntities: List<AchievementEntity> = achievementRepository.findAllByGameId(gameId)
        val achievements: ArrayList<Achievement> = ArrayList()
        achievementEntities.forEach {
            achievements.add(Achievement.fromDao(it))
        }
        return achievements
    }

    fun getAchievementsByGameIdAndClientUid(gameId: Long, clientUid: String): ArrayList<Achievement> {
        val achievementEntities: List<AchievementEntity> =
            achievementRepository.findAllByGameIdAndClientUid(gameId, clientUid)
        val achievements: ArrayList<Achievement> = ArrayList()
        achievementEntities.forEach {
            achievements.add(Achievement.fromDao(it))
        }
        return achievements
    }

}
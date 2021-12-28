package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.model.Achievement
import com.nitramite.gamescoreapi.model.AchievementType
import com.nitramite.gamescoreapi.service.AchievementService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/achievements")
class AchievementController(
    private val achievementService: AchievementService,
) {

    @PostMapping("/achievementType")
    fun postAchievementType(@RequestBody achievementType: AchievementType): AchievementType? {
        return achievementService.addAchievementType(
            achievementType.gameId,
            achievementType.name,
            achievementType.description
        )
    }

    @PostMapping("/achievement")
    fun postAchievement(@RequestBody achievement: Achievement): Achievement? {
        return achievementService.addAchievement(
            achievement.gameId,
            achievement.clientUid,
            achievement.achievementTypeId
        )
    }

    @GetMapping("/achievementsByGameId")
    fun getAchievementsByGameIdAndClientUid(@RequestParam gameId: Long): List<Achievement>? {
        return achievementService.getAchievementsByGameId(gameId)
    }

    @GetMapping("/achievementsByGameIdAndClientUid")
    fun getAchievementsByGameIdAndClientUid(@RequestParam gameId: Long, clientUid: String): List<Achievement>? {
        return achievementService.getAchievementsByGameIdAndClientUid(gameId, clientUid)
    }

}
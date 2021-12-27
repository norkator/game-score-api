package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.model.Achievement
import com.nitramite.gamescoreapi.model.AchievementType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/achievements")
class AchievementController(
    // private val clientService: ClientService,
) {

    @PostMapping("/achievementType")
    fun postAchievementType(@RequestBody achievementType: AchievementType): AchievementType? {
        // return achievementService.addAchievementType(achievementType...)
        return null
    }

    @PostMapping("/achievement")
    fun postAchievement(@RequestBody achievement: Achievement): Achievement? {
        // return achievementService.addAchievement(achievement...)
        return null
    }

    @GetMapping("/achievementByGameIdAndClientUid")
    fun getAchievementsByGameIdAndClientUid(@RequestParam gameId: Long, clientUid: String): List<Achievement>? {
        // return achievementService.addAchievement(achievement...)
        return null
    }

}
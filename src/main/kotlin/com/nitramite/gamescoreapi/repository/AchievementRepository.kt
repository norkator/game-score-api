package com.nitramite.gamescoreapi.repository

import com.nitramite.gamescoreapi.dao.AchievementEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.transaction.Transactional

@Repository
@Transactional
interface AchievementRepository : CrudRepository<AchievementEntity, Long> {

    fun findAllByGameId(gameId: Long): List<AchievementEntity>

    fun findAllByGameIdAndClientUid(gameId: Long, clientUid: String): List<AchievementEntity>

}
package com.nitramite.gamescoreapi.repository

import com.nitramite.gamescoreapi.dao.ScoreEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.transaction.Transactional

@Repository
@Transactional
interface ScoreRepository : CrudRepository<ScoreEntity, Long> {

    fun findAllByGameIdAndClientUid(gameId: Long, clientUid: String): Optional<ScoreEntity>

}
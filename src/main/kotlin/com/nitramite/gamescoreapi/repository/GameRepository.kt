package com.nitramite.gamescoreapi.repository

import com.nitramite.gamescoreapi.dao.GameEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface GameRepository : CrudRepository<GameEntity, Long> {

    fun findAllByUserIdAndId(userId: Long, gameId: Long): List<GameEntity>

}
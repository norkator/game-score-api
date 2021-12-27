package com.nitramite.gamescoreapi.service

import com.nitramite.gamescoreapi.dao.GameEntity
import com.nitramite.gamescoreapi.model.Game
import com.nitramite.gamescoreapi.repository.GameRepository
import org.springframework.stereotype.Service

@Service
class GameService(private val gameRepository: GameRepository) {

    fun addGame(name: String, description: String?): Game {
        val newGame = GameEntity(null, name, description, true)
        gameRepository.save(newGame)
        return Game.fromDao(newGame)
    }

}
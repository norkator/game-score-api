package com.nitramite.gamescoreapi.service

import com.nitramite.gamescoreapi.dao.GameEntity
import com.nitramite.gamescoreapi.model.Game
import com.nitramite.gamescoreapi.model.User
import com.nitramite.gamescoreapi.repository.GameRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameService(
    private val gameRepository: GameRepository,
    private val userService: UserService,
) {

    fun addGame(name: String, description: String?, userId: Long): Game {
        val newGame = GameEntity(null, name, description, true, userId)
        gameRepository.save(newGame)
        return Game.fromDao(newGame)
    }

    fun getGames(gameId: Long): ArrayList<Game> {
        val games: ArrayList<Game> = ArrayList()
        val username: String = SecurityContextHolder.getContext().authentication.principal.toString()
        val user: User = userService.findUserByUsername(username) ?: return games

        val gameEntities: List<GameEntity> = gameRepository.findAllByUserIdAndId(user.id, gameId)
        gameEntities.forEach {
            games.add(Game.fromDao(it))
        }
        return games
    }

}
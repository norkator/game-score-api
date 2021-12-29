package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.model.Game
import com.nitramite.gamescoreapi.service.GameService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/games")
class GameController(
    private val gameService: GameService,
) {

    @PostMapping("/game")
    fun postGame(@RequestBody game: Game): Game? {
        return gameService.addGame(game.name, game.description, game.userId)
    }

    // @GetMapping("/game")
    // fun getGame(@RequestBody game: Game): Game? {
    //     return null
    // }

    @GetMapping("/games")
    fun getGames(@RequestParam gameId: Long): ArrayList<Game> {
        return gameService.getGames(gameId)
    }

}
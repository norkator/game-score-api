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
    // Todo.. get game

    // @GetMapping("/games")
    // Todo.. get games

}
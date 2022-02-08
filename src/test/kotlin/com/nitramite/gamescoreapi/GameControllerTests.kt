package com.nitramite.gamescoreapi

import com.nitramite.gamescoreapi.controller.GameController
import com.nitramite.gamescoreapi.repository.GameRepository
import com.nitramite.gamescoreapi.security.CustomAuthenticationProvider
import com.nitramite.gamescoreapi.service.GameService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(GameController::class)
class GameControllerTests {

    @Autowired
    var mockMvc: MockMvc? = null

    @MockBean
    private lateinit var gameRepository: GameRepository

    @MockBean
    private lateinit var gameService: GameService

    @MockBean
    private lateinit var customAuthProvider: CustomAuthenticationProvider


    @BeforeEach
    fun setup() {
    }

    @Test
    @Throws(Exception::class)
    fun should_post_new_game() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .post("/games/game")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"test game\", \"description\":\"example game\", \"userId\": 1}")
        )
            .andExpect(status().isOk())
    }

}

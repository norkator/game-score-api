package com.nitramite.gamescoreapi

import com.nitramite.gamescoreapi.controller.ScoreController
import com.nitramite.gamescoreapi.repository.ScoreRepository
import com.nitramite.gamescoreapi.security.CustomAuthenticationProvider
import com.nitramite.gamescoreapi.service.ScoreService
import com.nitramite.gamescoreapi.service.UserService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(ScoreController::class)
class ScoreControllerTests {

    @Autowired
    var mockMvc: MockMvc? = null

    @MockBean
    private lateinit var scoreRepository: ScoreRepository

    @MockBean
    private lateinit var scoreService: ScoreService

    @MockBean
    private lateinit var userService: UserService

    @MockBean
    private lateinit var customAuthProvider: CustomAuthenticationProvider


    @BeforeEach
    fun setup() {
    }

    @Test
    @Throws(Exception::class)
    fun should_return_score_for_game_and_client() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .get("/scores/score")
                .param("gameId", "1")
                .param("clientUid", "65865e0a-c0a5-49b5-9070-9b5095abbb69")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun should_return_best_scores_by_game() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .get("/scores/bestByGame")
                .param("gameId", "1")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun should_post_new_score() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .post("/scores/score")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"gameId\":1, \"clientUid\": \"65865e0a-c0a5-49b5-9070-9b5095abbb69\", \"score\": 100}")
        )
        .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun should_return_scores_for_client() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .get("/scores/forClient")
                .param("clientUid", "65865e0a-c0a5-49b5-9070-9b5095abbb69")
                .param("gameIds", "1")
                .param("gameIds", "2")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
    }

}

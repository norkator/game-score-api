package com.nitramite.gamescoreapi

import com.nitramite.gamescoreapi.controller.AchievementController
import com.nitramite.gamescoreapi.repository.AchievementRepository
import com.nitramite.gamescoreapi.security.CustomAuthenticationProvider
import com.nitramite.gamescoreapi.service.AchievementService
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


@WebMvcTest(AchievementController::class)
class AchievementControllerTests {

    @Autowired
    var mockMvc: MockMvc? = null

    @MockBean
    private lateinit var achievementRepository: AchievementRepository

    @MockBean
    private lateinit var achievementService: AchievementService

    @MockBean
    private lateinit var userService: UserService

    @MockBean
    private lateinit var customAuthProvider: CustomAuthenticationProvider


    @BeforeEach
    fun setup() {
    }

    @Test
    @Throws(Exception::class)
    fun should_post_new_achievement_type() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .post("/achievements/achievementType")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"gameId\":1, \"name\": \"achievement name\", \"description\":\"example description\"}")
        )
            .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun should_post_new_achievement() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .post("/achievements/achievement")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"gameId\":1, \"clientUid\": \"65865e0a-c0a5-49b5-9070-9b5095abbb69\", \"achievementTypeId\": 1}")
        )
            .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun should_return_achievements_by_game_id() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .get("/achievements/achievementsByGameId")
                .param("gameId", "1")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun should_return_achievements_by_game_id_and_client_uid() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .get("/achievements/achievementsByGameIdAndClientUid")
                .param("gameId", "1")
                .param("clientUid", "65865e0a-c0a5-49b5-9070-9b5095abbb69")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
    }

}

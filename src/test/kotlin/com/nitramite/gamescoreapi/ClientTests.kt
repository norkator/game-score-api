package com.nitramite.gamescoreapi

import com.nitramite.gamescoreapi.controller.ClientController
import com.nitramite.gamescoreapi.dao.ClientEntity
import com.nitramite.gamescoreapi.repository.ClientRepository
import com.nitramite.gamescoreapi.security.CustomAuthenticationProvider
import com.nitramite.gamescoreapi.service.ClientService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.Instant


@WebMvcTest(ClientController::class)
class ClientTests {

    @Autowired
    var mockMvc: MockMvc? = null

    @MockBean
    private lateinit var clientRepository: ClientRepository

    @MockBean
    private lateinit var clientService: ClientService

    @MockBean
    private lateinit var customAuthProvider: CustomAuthenticationProvider

    var clientEntity: ClientEntity =
        ClientEntity("65865e0a-c0a5-49b5-9070-9b5095abbb69", Instant.now(), Instant.now(), "name_1")

    @BeforeEach
    fun setup() {
        given(this.clientRepository.findByClientUid("65865e0a-c0a5-49b5-9070-9b5095abbb69")).willReturn(clientEntity)
    }

    @Test
    @Throws(Exception::class)
    fun should_return_new_uid() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .get("/clients/generateUid")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
    }

}

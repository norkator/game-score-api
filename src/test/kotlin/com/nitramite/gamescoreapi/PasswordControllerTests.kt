package com.nitramite.gamescoreapi

import com.nitramite.gamescoreapi.controller.PasswordController
import com.nitramite.gamescoreapi.security.CustomAuthenticationProvider
import com.nitramite.gamescoreapi.service.PasswordService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(PasswordController::class)
class PasswordControllerTests {

    @Autowired
    var mockMvc: MockMvc? = null

    @MockBean
    private lateinit var passwordService: PasswordService

    @MockBean
    private lateinit var customAuthProvider: CustomAuthenticationProvider

    @BeforeEach
    fun setup() {
    }

    @Test
    @Throws(Exception::class)
    fun should_return_encoded_password() {
        mockMvc!!.perform(
            MockMvcRequestBuilders
                .get("/password/encoded")
                .param("plaintext", "my_test_password_!@?")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
    }

}

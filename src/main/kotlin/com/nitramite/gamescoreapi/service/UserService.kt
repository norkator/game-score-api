package com.nitramite.gamescoreapi.service

import com.nitramite.gamescoreapi.dao.UserEntity
import com.nitramite.gamescoreapi.model.User
import com.nitramite.gamescoreapi.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun findUserByUsernameAndPassword(username: String, password: String): User? {
        val user: Optional<UserEntity> = userRepository.findByUsernameAndPasswordAndEnabledTrue(username, password)
        return if (user.isPresent) User.fromDao(user.get()) else null
    }

}
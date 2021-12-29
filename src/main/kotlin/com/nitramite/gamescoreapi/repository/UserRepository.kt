package com.nitramite.gamescoreapi.repository

import com.nitramite.gamescoreapi.dao.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.transaction.Transactional

@Repository
@Transactional
interface UserRepository : CrudRepository<UserEntity, Long> {

    fun findByUsernameAndPasswordAndEnabledTrue(username: String, password: String): Optional<UserEntity>

    fun findByUsernameAndEnabledTrue(username: String): Optional<UserEntity>

}
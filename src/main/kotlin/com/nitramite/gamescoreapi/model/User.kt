package com.nitramite.gamescoreapi.model

import com.nitramite.gamescoreapi.dao.UserEntity

class User(
    val id: Long,
    var username: String,
    var password: String,
    var role: String,
    var enabled: Boolean = true,
) {
    companion object {
        fun fromDao(userEntity: UserEntity) = User(
            userEntity.id,
            userEntity.username,
            userEntity.password,
            userEntity.role,
            userEntity.enabled,
        )
    }
}
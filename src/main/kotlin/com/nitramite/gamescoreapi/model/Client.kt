package com.nitramite.gamescoreapi.model

import com.nitramite.gamescoreapi.dao.ClientEntity
import java.time.Instant

class Client(
    val clientUid: String,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now(),
    val nickname: String? = null
) {
    companion object {
        fun fromDao(clientEntity: ClientEntity) = Client(
            clientEntity.clientUid,
            clientEntity.createdAt,
            clientEntity.updatedAt,
            clientEntity.nickname
        )
    }
}
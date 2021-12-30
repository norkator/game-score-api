package com.nitramite.gamescoreapi.dao

import java.time.Instant
import javax.persistence.*

@Entity(name = "client")
class ClientEntity(

    @Id
    @Column(name = "clientuid", nullable = false, unique = true)
    val clientUid: String,

    @Column(name = "createdat")
    var createdAt: Instant = Instant.now(),

    @Column(name = "updatedat")
    var updatedAt: Instant = Instant.now(),

    @Column(nullable = true, unique = false)
    var nickname: String? = null

)
package com.nitramite.gamescoreapi.dao

import java.time.Instant
import javax.persistence.*

@Entity(name = "score")
class ScoreEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    @Column(name = "gameid", nullable = false, unique = false)
    val gameId: Long,

    @Column(name = "clientuid", nullable = false, unique = false)
    val clientUid: String,

    @Column(nullable = false)
    var score: Long,

    @Column(name = "createdat")
    var createdAt: Instant = Instant.now(),

    @Column(name = "updatedat")
    var updatedAt: Instant = Instant.now()
)
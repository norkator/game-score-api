package com.nitramite.gamescoreapi.dao

import java.time.Instant
import javax.persistence.*

@Entity(name = "achievement")
class AchievementEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    @Column(name = "gameid", nullable = false, unique = false)
    val gameId: Long,

    @Column(name = "clientuid", nullable = false, unique = false)
    val clientUid: String,

    @Column(name = "achievementtypeid", nullable = false, unique = false)
    val achievementTypeId: Long,

    @Column(name = "createdat")
    val createdAt: Instant = Instant.now(),

    @Column(name = "updatedat")
    val updatedAt: Instant = Instant.now()
)
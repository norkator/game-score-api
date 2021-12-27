package com.nitramite.gamescoreapi.dao

import java.time.Instant
import javax.persistence.*

@Entity(name = "achievement")
class AchievementEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val gameId: Long,

    @Column(nullable = false, unique = true)
    val clientUid: String,

    @Column(nullable = false, unique = true)
    val achievementTypeId: Long,

    val createdAt: Instant = Instant.now(),

    val updatedAt: Instant = Instant.now()
)
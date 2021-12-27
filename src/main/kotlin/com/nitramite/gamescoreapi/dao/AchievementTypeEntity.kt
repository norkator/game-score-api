package com.nitramite.gamescoreapi.dao

import javax.persistence.*

@Entity(name = "achievementtype")
class AchievementTypeEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = true)
    val description: String,
)
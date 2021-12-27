package com.nitramite.gamescoreapi.dao

import javax.persistence.*

@Entity(name = "game")
class GameEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    val name: String,

    val description: String?,

    val enabled: Boolean = true,
)
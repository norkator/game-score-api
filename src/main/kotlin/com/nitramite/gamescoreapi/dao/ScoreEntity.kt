package com.nitramite.gamescoreapi.dao

import javax.persistence.*

@Entity(name = "score")
class ScoreEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val score: Long,
)
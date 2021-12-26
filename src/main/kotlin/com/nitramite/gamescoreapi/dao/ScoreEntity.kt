package com.nitramite.gamescoreapi.dao

import javax.persistence.*

@Entity(name = "score")
class ScoreEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val name: String
)
package com.nitramite.gamescoreapi.dao

import javax.persistence.*

@Entity(name = "user")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    val username: String,

    val password: String,

    val enabled: Boolean = true

)
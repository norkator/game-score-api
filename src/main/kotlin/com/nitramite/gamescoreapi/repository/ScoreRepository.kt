package com.nitramite.gamescoreapi.repository

import com.nitramite.gamescoreapi.dao.ScoreEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface ScoreRepository : CrudRepository<ScoreEntity, Long>
package com.nitramite.gamescoreapi.repository

import com.nitramite.gamescoreapi.dao.AchievementTypeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface AchievementTypeRepository : CrudRepository<AchievementTypeEntity, Long>
package com.nitramite.gamescoreapi.repository

import com.nitramite.gamescoreapi.dao.ClientEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface ClientRepository : CrudRepository<ClientEntity, String>
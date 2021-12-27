package com.nitramite.gamescoreapi.service

import com.nitramite.gamescoreapi.dao.ClientEntity
import com.nitramite.gamescoreapi.model.Client
import com.nitramite.gamescoreapi.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientService(private val clientRepository: ClientRepository) {

    fun addClient(clientUid: String): Client {
        val newClient = ClientEntity(clientUid)
        clientRepository.save(newClient)
        return Client.fromDao(newClient)
    }

}
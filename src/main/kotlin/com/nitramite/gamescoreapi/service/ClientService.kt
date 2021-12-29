package com.nitramite.gamescoreapi.service

import com.nitramite.gamescoreapi.dao.ClientEntity
import com.nitramite.gamescoreapi.model.Client
import com.nitramite.gamescoreapi.repository.ClientRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientService(private val clientRepository: ClientRepository) {

    private fun randomUUID() = UUID.randomUUID().toString()

    fun generateUid(): Client {
        val clientUid: String = randomUUID()
        val newClient = ClientEntity(clientUid)
        clientRepository.save(newClient)
        return Client.fromDao(newClient)
    }

    fun addClient(clientUid: String): Client {
        val newClient = ClientEntity(clientUid)
        clientRepository.save(newClient)
        return Client.fromDao(newClient)
    }

}
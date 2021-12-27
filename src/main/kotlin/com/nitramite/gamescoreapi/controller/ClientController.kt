package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.service.ClientService
import com.nitramite.gamescoreapi.model.Client
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clients")
class ClientController(
    private val clientService: ClientService,
) {

    @PostMapping("/client")
    fun postClient(@RequestBody Client: Client): Client? {
        return clientService.addClient(Client.clientUid)
    }

}
package com.nitramite.gamescoreapi.controller

import com.nitramite.gamescoreapi.model.Client
import com.nitramite.gamescoreapi.service.ClientService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clients")
class ClientController(
    private val clientService: ClientService,
) {

    @GetMapping("/generateUid")
    fun getGeneratedUid(): Client? {
        return clientService.generateUid()
    }

    @PostMapping("/client")
    fun postClient(@RequestBody Client: Client): Client? {
        return clientService.addClient(Client.clientUid)
    }

}
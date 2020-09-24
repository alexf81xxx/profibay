package com.profibay.api.controller;


import com.profibay.api.model.Client;
import com.profibay.api.model.enums.StatusesEnum;
import com.profibay.api.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/client")

public class ClientController {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientController(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @RequestMapping("add")
    @PostMapping
    public ResponseEntity addClient (@RequestBody Client client)
    {

        client.setCreated(LocalDateTime.now());
        client.setUpdated(LocalDateTime.now());
        client.setStatus(StatusesEnum.ACTIVE);

        Client savedClient = clientRepo.save(client);
        return ResponseEntity.ok(savedClient);
    }


    @RequestMapping("update")
    @PostMapping
    public ResponseEntity updateClient

            (@RequestBody Client client)
    {

   Client returnedClient = clientRepo.findByNameAndSurnameAndPhone1(client.getName(), client.getSurname(), client.getPhone1());


        returnedClient.setAge(client.getAge());
        returnedClient.setPhone2(client.getPhone2());


        Client client2 =  clientRepo.save(returnedClient);

        return ResponseEntity.ok(client2);
    }
}
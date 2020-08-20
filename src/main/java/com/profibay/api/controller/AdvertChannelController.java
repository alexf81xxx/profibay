package com.profibay.api.controller;

import com.profibay.api.model.AdvertCahannel;
import com.profibay.api.model.enums.Statuses;
import com.profibay.api.repo.AdvertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/advert_channel")

public class AdvertChannelController {

    public final AdvertRepo advertRepo;
    @Autowired
    public AdvertChannelController(AdvertRepo advertRepo) {
        this.advertRepo = advertRepo;
    }

    @PostMapping("add")
    public ResponseEntity addMaster(@RequestBody AdvertCahannel advertCahannel) {

        System.out.println(advertCahannel);


        advertCahannel.setCreated(LocalDateTime.now()); // Присвоили время создания
        advertCahannel.setUpdated(LocalDateTime.now()); // Присвоил время updated
        advertCahannel.setStatus(Statuses.ACTIVE); //Статус
        return ResponseEntity.ok(advertRepo.save(advertCahannel)); // ResponseEntity.ok - Для оповещения при помощи ответов сервера
    }
}

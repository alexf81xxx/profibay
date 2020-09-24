package com.profibay.api.controller;

import com.profibay.api.dto.MasterReviewDto;
import com.profibay.api.model.Master;
import com.profibay.api.model.MasterReview;
import com.profibay.api.model.enums.StatusesEnum;
import com.profibay.api.repo.MasterRepo;
import com.profibay.api.repo.MasterReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/master_review")

public class MasterReviewController {

    private final MasterReviewRepo masterReviewRepo;
    private final MasterRepo masterRepo;

    @Autowired
    public MasterReviewController(MasterReviewRepo masterReviewRepo, MasterRepo masterRepo) {
        this.masterReviewRepo = masterReviewRepo;
        this.masterRepo = masterRepo;
    }

    @PostMapping("add")
    public ResponseEntity addReview(@RequestBody MasterReviewDto masterReviewDto) { // К нам приходит данный пользователь типа MasterReviewDto
        //  Но В БД мы хотим записать MasterReview значит нам нужно из MasterReviewDto преобразовать в MasterReview

        MasterReview masterReview = new MasterReview();
        masterReview.setReview(masterReviewDto.getReview()); // Получил отзыв пришедший в аргументах

        Master master = masterRepo.findByPhone1(masterReviewDto.getMasterPhone1()); // Нашёл по номеру телефона мастера который пришёл в аргументах

        masterReview.setMaster(master);// Отзыву присваиваю конкретного мастера, которого строкой выше нашёл по номеру телефона

        masterReview.setCreated(LocalDateTime.now());
        masterReview.setUpdated(LocalDateTime.now());
        masterReview.setStatus(StatusesEnum.ACTIVE);

        MasterReview masterReviewSaved = masterReviewRepo.save(masterReview);
        return ResponseEntity.ok(masterReviewSaved);
    }

    @PostMapping("add_to_dto")
    public  ResponseEntity addReviewDto (@RequestBody MasterReviewDto masterReviewDto){

        MasterReview masterReview = masterReviewDto.toMasterReview();

        Master master = masterRepo.findByPhone1(masterReviewDto.getMasterPhone1()); // Нашёл по номеру телефона мастера который пришёл в аргументах
        masterReview.setMaster(master);// Отзыву присваиваю конкретного мастера, которого строкой выше нашёл по номеру телефона

        masterReview.setCreated(LocalDateTime.now());
        masterReview.setUpdated(LocalDateTime.now());
        masterReview.setStatus(StatusesEnum.ACTIVE);

        MasterReview masterReviewSaved = masterReviewRepo.save(masterReview);
        return ResponseEntity.ok(masterReviewSaved);

    }
}

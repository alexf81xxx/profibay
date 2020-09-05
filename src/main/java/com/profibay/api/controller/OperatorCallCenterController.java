package com.profibay.api.controller;


import com.profibay.api.model.OperatorCallCenter;
import com.profibay.api.model.enums.Statuses;
import com.profibay.api.repo.OperatorCallCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/operator_call_center")

public class OperatorCallCenterController {
    public final OperatorCallCenterRepo operatorCallCenterRepo;

    @Autowired
    public OperatorCallCenterController(OperatorCallCenterRepo operatorCallCentrRepo) {
        this.operatorCallCenterRepo = operatorCallCentrRepo;
    }


    @PostMapping("add")
    public ResponseEntity addOperatorCallCenter(@RequestBody OperatorCallCenter operatorCallCenter) {

        operatorCallCenter.setCreated(LocalDateTime.now());
        operatorCallCenter.setUpdated(LocalDateTime.now());
        operatorCallCenter.setStatus(Statuses.ACTIVE);

        OperatorCallCenter operatorCallCenter1 = operatorCallCenterRepo.save(operatorCallCenter);

        return ResponseEntity.ok("Пользователь" + operatorCallCenter1.getName() + " был добавлен \n" + operatorCallCenter1);
    }

    @PostMapping("update")

    public ResponseEntity updateByNameAndSurname (@RequestBody OperatorCallCenter operatorCallCenter) {

        OperatorCallCenter operatorCallCenter1 = operatorCallCenterRepo.findByNameAndSurname(operatorCallCenter.getName(), operatorCallCenter.getSurname());

        operatorCallCenter1.setUpdated(LocalDateTime.now());
        operatorCallCenter1.setNote_about_operator(operatorCallCenter.getNote_about_operator());

        operatorCallCenterRepo.save(operatorCallCenter1);

        return ResponseEntity.ok(operatorCallCenter1.getName() + " был изменён.");
    }



    @PostMapping("delete")

    public ResponseEntity deleteByNameAndSurname (@RequestBody OperatorCallCenter operatorCallCenter) {

        OperatorCallCenter operatorCallCenter1 = operatorCallCenterRepo.findByNameAndSurname(operatorCallCenter.getName(), operatorCallCenter.getSurname());

        operatorCallCenterRepo.delete(operatorCallCenter1);

        return ResponseEntity.ok(operatorCallCenter1.getName() + " был удалён.");
    }


    @PostMapping("my_query_insert_operator")
    public ResponseEntity insertOperator (@RequestBody OperatorCallCenter operatorCallCenter){

        Date dateNow = new Date(); // Создаю объект с текущей датой - создаётся автоматически

        Integer operatorCallCenter1 = operatorCallCenterRepo.insert(operatorCallCenter.getName(), operatorCallCenter.getSurname(),
        operatorCallCenter.getPatronymic(), operatorCallCenter.getBirthday(),
        operatorCallCenter.getSex(), operatorCallCenter.getPhone1(), operatorCallCenter.getPhone2(), operatorCallCenter.getCity(), operatorCallCenter.getImg(),
        Statuses.ACTIVE.toString(),
        operatorCallCenter.getNote_about_operator(), operatorCallCenter.getRating(), dateNow, dateNow,
        operatorCallCenter.getPatronymic());

        if (operatorCallCenter1 ==1){
            return ResponseEntity.ok(operatorCallCenter);
        }else {
            return ResponseEntity.badRequest().build();
        }


    }



}

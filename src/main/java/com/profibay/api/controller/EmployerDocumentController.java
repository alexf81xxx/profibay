package com.profibay.api.controller;


import com.profibay.api.model.EmployerDocument;
import com.profibay.api.model.enums.EmployerType;
import com.profibay.api.model.enums.Statuses;
import com.profibay.api.repo.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employer_document")

public class EmployerDocumentController {

    public final EmployerRepo employerRepo;

    @Autowired
    public EmployerDocumentController(EmployerRepo employerRepo) {
        this.employerRepo = employerRepo;
    }

    @PostMapping("add")
    public ResponseEntity addEmployerDocument(@RequestBody EmployerDocument employerDocument) {

        employerDocument.setCreated(LocalDateTime.now());
        employerDocument.setUpdated(LocalDateTime.now());
        employerDocument.setEmployerType(EmployerType.MASTER);
        employerDocument.setStatus(Statuses.ACTIVE);

        System.out.println("11 " +employerDocument);

        EmployerDocument employerDocument2 = employerRepo.save(employerDocument); // save метод возвращает записанный объект в БД
        System.out.println(employerDocument2);

        return ResponseEntity.ok(employerDocument2);


    }



    @PostMapping("add/many")
    public ResponseEntity addEmployerDocument(@RequestBody List<EmployerDocument> employerDocumentList) {
        List<EmployerDocument> employerDocumentList1 = new ArrayList<>();

//        employerDocumentList.forEach(x -> {
//            x.setCreated(LocalDateTime.now());
//            x.setUpdated(LocalDateTime.now());
//            x.setEmployerType(EmployerType.MASTER);
//            x.setStatus(Statuses.ACTIVE);
//
//            employerDocumentList1.add(employerRepo.save(x));
//        });
//

        for (EmployerDocument x : employerDocumentList) {

            x.setCreated(LocalDateTime.now());
            x.setUpdated(LocalDateTime.now());
            x.setEmployerType(EmployerType.MASTER);
            x.setStatus(Statuses.ACTIVE);

            employerDocumentList1.add(employerRepo.save(x));
        }

        return ResponseEntity.ok(employerDocumentList1); // после return цикл останавливается сразу
    }
}



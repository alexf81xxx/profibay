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

@RestController
@RequestMapping ("/api/v1/employer_document")

public class EmployerDocumentController {

    public final EmployerRepo employerRepo;

    @Autowired
    public EmployerDocumentController(EmployerRepo employerRepo) {
        this.employerRepo = employerRepo;
    }

    @PostMapping("add")
    public ResponseEntity addEmployerDocument (@RequestBody EmployerDocument employerDocument){

        employerDocument.setCreated(LocalDateTime.now());
        employerDocument.setUpdated(LocalDateTime.now());
        employerDocument.setEmployerType(EmployerType.MASTER);
        employerDocument.setStatus(Statuses.ACTIVE);

        return ResponseEntity.ok(employerRepo.save(employerDocument));
    }
}

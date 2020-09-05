package com.profibay.api.controller;


import com.profibay.api.model.TypeOfWork;
import com.profibay.api.repo.TypeOfWorkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/type_of_work")

public class TypeOfWorkController {


    private final TypeOfWorkRepo typeOfWork;

    @Autowired
    public TypeOfWorkController(TypeOfWorkRepo typeOfWork) {
        this.typeOfWork = typeOfWork;
    }


    @PostMapping (name = "add")
    private ResponseEntity addTypeOfWork (@RequestBody TypeOfWork typeOfWorktSave)
{
    return ResponseEntity.ok(typeOfWork.save(typeOfWorktSave));
}

}

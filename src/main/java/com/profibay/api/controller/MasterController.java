package com.profibay.api.controller;


import com.profibay.api.dto.AddMasterDto;
import com.profibay.api.dto.MasterDto;
import com.profibay.api.model.EmployerDocument;
import com.profibay.api.model.Master;
import com.profibay.api.model.TypeOfWork;
import com.profibay.api.model.enums.StatusesEnum;
import com.profibay.api.model.enums.TypeOfWorkEnum;
import com.profibay.api.repo.EmployeeDocumentRepo;
import com.profibay.api.repo.MasterRepo;
import com.profibay.api.repo.TypeOfWorkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/master")

public class MasterController {

    private final MasterRepo masterRepo;
    private final TypeOfWorkRepo typeOfWorkRepo;
    private final EmployeeDocumentRepo employeeDocumentRepo;

    @Autowired
    public MasterController(MasterRepo masterRepo, TypeOfWorkRepo typeOfWorkRepo, EmployeeDocumentRepo employeeDocumentRepo) {
        this.masterRepo = masterRepo;
        this.typeOfWorkRepo = typeOfWorkRepo;
        this.employeeDocumentRepo = employeeDocumentRepo;
    }

    @PostMapping("add")
    public ResponseEntity addMaster(@RequestBody MasterDto masterDto) {

        System.out.println(masterDto);

//        List<TypeOfWorkEnum> findTypeOfWork = new ArrayList<>();//По нему будет совершен поиск работ в БД
//        List<TypeOfWork> masterTypeOfWorksList = master.getTypeOfWorks(); //получаем список объектов Типов работ, которые пришли от клиента
//        for (TypeOfWork i:masterTypeOfWorksList) {
//            findTypeOfWork.add(i.getTypeOfWork());
//        }
//        findTypeOfWork.add(TypeOfWorkEnum.PLUMBER);
//        findTypeOfWork.add(TypeOfWorkEnum.HANDYMAN);

        List<TypeOfWork> typeOfWorkList = typeOfWorkRepo.findByTypeOfWorkIn(masterDto.getTypeOfWorks()); // Достаём из БД список типов работ которые указаны строками выше


        Master master = masterDto.toMaster();// toMaster - означает - создать мастера

        master.setTypeOfWorks(typeOfWorkList); //присваиваем мастеру список типов работ, которые извлекли из БД

        System.out.println("Types of WOrk " + typeOfWorkList);

        // Из БД достать типы
        master.setCreated(LocalDateTime.now());
        master.setUpdated(LocalDateTime.now());
        master.setStatus(StatusesEnum.ACTIVE);
//      master.setTypeOfEmployment(TypeOfEmploymentEnum.FULL_TIME);

        Master masterSaved = masterRepo.save(master);
        return ResponseEntity.ok(masterSaved);

    }

    @PostMapping("add_master")

    public ResponseEntity addMasterDto(@RequestBody AddMasterDto addMasterDto) {

        EmployerDocument employerDocument = addMasterDto.getEmployerDocument();
        employerDocument.setCreated(LocalDateTime.now());
        employerDocument.setUpdated(LocalDateTime.now());
        employerDocument.setStatus(StatusesEnum.ACTIVE);
        EmployerDocument employerDocumentSave = employeeDocumentRepo.save(employerDocument);

        addMasterDto.getMaster().setCreated(LocalDateTime.now());
        addMasterDto.getMaster().setUpdated(LocalDateTime.now());
        addMasterDto.getMaster().setStatus(StatusesEnum.ACTIVE);

        addMasterDto.getMaster().setEmployerDocument(employerDocumentSave);

        List<TypeOfWorkEnum> typeOfWork = addMasterDto.getTypeOfWork(); // Хранит в виде ENUM типы работ полученные из фронта
        System.out.println("==============" + typeOfWork);


        System.out.println(typeOfWorkRepo.findByTypeOfWorkIn(typeOfWork));// Совершил поиск по типам работ

        addMasterDto.getMaster().setTypeOfWorks(typeOfWorkRepo.findByTypeOfWorkIn(typeOfWork));

        Master masterSave = masterRepo.save(addMasterDto.getMaster()); // Записал мастера

        System.out.println(addMasterDto);
        return ResponseEntity.ok(masterSave);
    }

}

package com.profibay.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.profibay.api.model.enums.TypeOfEmploymentEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "master")

@Data
@NoArgsConstructor
public class Master extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "sex")
    private String sex;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "city")
    private String city;

    @Column(name = "type_of_employment")
    @Enumerated(EnumType.STRING) // Преобразовать enum в строку при отправке запроса в БД
    private TypeOfEmploymentEnum typeOfEmployment;

    @Column(name = "car")
    private boolean car;

    @Column(name = "preferred_area")
    private String preferredArea;

    @Column(name = "img")
    private String img;

    @Column(name = "note_about_master")
    //@JsonProperty("note_about_master")
    private String noteAboutMaster;

    @Column(name = "rating")
    private float rating;

    @OneToMany (mappedBy = "master")
    private List<MasterReview> reviews;

    @OneToOne
    @JoinColumn (name = "id_employer_document")
    private EmployerDocument employerDocument;

    @ManyToMany
    @JoinTable(
            name = "master_to_type_of_work",
    joinColumns = @JoinColumn(name = "master_id"),
    inverseJoinColumns = @JoinColumn(name = "type_of_work_id"))
    private List<TypeOfWork> typeOfWorks;

    @OneToOne ()
    @JoinColumn (name = "id_employer_img")
    private EmployerImg idEmployerImg;

    public Master(String name, String surname, String patronymic, Date birthday, String sex, String phone1, String phone2, String city, TypeOfEmploymentEnum typeOfEmployment, boolean car, String preferredArea, String img, String noteAboutMaster, float rating) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.sex = sex;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.city = city;
        this.typeOfEmployment = typeOfEmployment;
        this.car = car;
        this.preferredArea = preferredArea;
        this.img = img;
        this.noteAboutMaster = noteAboutMaster;
        this.rating = rating;
    }
}


/*
"name":"",
"surname":"",
"patronymic":"",
"birthday":"",
"sex":"",
"phone1":"",
"phone2":"",
"city":"",
"typeOfEmployment":"",
"car":"",
'preferredArea":"",
"img":"",
"noteAboutMaster":"",
"rating":"",
"typeOfWorks":""
*/

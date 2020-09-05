package com.profibay.api.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity

@Data
@NoArgsConstructor
public class OperatorCallCenter extends BaseModel {


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

    @Column(name = "img")
    private String img;

    @Column(name = "note_about_operator")
    private String note_about_operator;

    @Column(name = "rating")
    private int rating;

}

package com.profibay.api.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@NoArgsConstructor

@Entity (name = "client")
public class Client extends BaseModel {

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column (name = "age")
    @JsonProperty ("range")
    private String age;

    @Column (name = "phone1")
    private String phone1;

    @Column (name = "phone2")
    private String phone2;

    @Column (name = "sex")
    private String sex;

    @Column (name = "description")
    private String description;

}


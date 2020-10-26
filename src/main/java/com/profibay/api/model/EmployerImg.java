package com.profibay.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity (name = "employer_documents")
public class EmployerImg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column (name = "img")
    private String employerImg;

    @OneToOne (mappedBy = "idEmployerImg")
    private Master masterId;





}

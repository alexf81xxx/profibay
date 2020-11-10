package com.profibay.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.profibay.api.interfaces.EmployerEntityIntarface;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity (name = "employer_img")
public class EmployerImg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column (name = "img")
    private String employerImg;

    @OneToOne (mappedBy = "operatorCallCenterImg", cascade = CascadeType.ALL)
    private OperatorCallCenter operatorCallCenterImg;

    @OneToOne (mappedBy = "masterImg", cascade = CascadeType.ALL)
    private Master masterImg;


}

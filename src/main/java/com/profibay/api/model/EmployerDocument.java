package com.profibay.api.model;

import com.profibay.api.model.enums.EmployerType;
import com.profibay.api.model.enums.Statuses;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity (name = "employer_documents")
public class EmployerDocument extends BaseModel {


    @Column (name = "employer_id")
    private int employerId;

    @Column (name = "passport_num")
    private int passportNum;

    @Column (name = "passport_series")
    private int passportSeries;

    @Column (name = "date_of_issue")
    private Date dateOfIssue;

    @Column (name = "department_code")
    private int departmentCode;

    @Column (name = "issued_by")
    private Date issuedBy;

    @Column (name = "registration")
    private String registration;

    @Column (name = "sex")
    private String sex;

    @Column (name = "status")
    private Statuses status;

    @Column (name = "employer_type")
    private EmployerType employerType;



}

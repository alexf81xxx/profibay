package com.profibay.api.model;

import com.profibay.api.model.enums.EmployerTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity (name = "employer_documents")
public class EmployerDocument extends BaseModel {


    @Column (name = "passport_num")
    private String passportNum;

    @Column (name = "passport_series")
    private String passportSeries;

    @Column (name = "date_of_issue")
    private Date dateOfIssue;

    @Column (name = "department_code")
    private String departmentCode;

    @Column (name = "issued_by")
    private Date issuedBy;

    @Column (name = "registration")
    private String registration;

    @Column (name = "sex")
    private String sex;

    @Column (name = "employer_type")
    private EmployerTypeEnum employerType;

    @OneToOne (mappedBy = "employerDocument")
    private Master master;

    @Override
    public String toString() {
        return "EmployerDocument{" +
                "id="+getId()+"  "+
                "created=" +getCreated()+ " "+
                "passportNum='" + passportNum + '\'' +
                ", passportSeries='" + passportSeries + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", departmentCode='" + departmentCode + '\'' +
                ", issuedBy=" + issuedBy +
                ", registration='" + registration + '\'' +
                ", sex='" + sex + '\'' +
                ", employerType=" + employerType +
                '}';
    }
}

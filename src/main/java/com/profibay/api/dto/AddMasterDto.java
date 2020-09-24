package com.profibay.api.dto;


import com.profibay.api.model.EmployerDocument;
import com.profibay.api.model.Master;
import com.profibay.api.model.TypeOfWork;
import com.profibay.api.model.enums.TypeOfEmploymentEnum;
import com.profibay.api.model.enums.TypeOfWorkEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor

public class AddMasterDto {
    private Master master;
    private EmployerDocument employerDocument;
    private List<TypeOfWorkEnum> typeOfWork;

}

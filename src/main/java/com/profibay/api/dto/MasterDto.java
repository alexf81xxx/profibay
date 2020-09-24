package com.profibay.api.dto;

import com.profibay.api.model.Master;
import com.profibay.api.model.TypeOfWork;
import com.profibay.api.model.enums.TypeOfEmploymentEnum;
import com.profibay.api.model.enums.TypeOfWorkEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class MasterDto {
    private String name;
    private String surname;
    private String patronymic;
    private Date birthday;
    private String sex;
    private String phone1;
    private String phone2;
    private String city;
    private TypeOfEmploymentEnum typeOfEmployment;
    private boolean car;
    private String preferredArea;
    private String img;
    private String noteAboutMaster;
    private float rating;
    private List<TypeOfWorkEnum> typeOfWorks;

    public Master toMaster(){
        return new Master(
                name,surname,patronymic,birthday,sex,phone1,phone2,city,typeOfEmployment,car,
                preferredArea,img,noteAboutMaster,rating
                );
    }
}

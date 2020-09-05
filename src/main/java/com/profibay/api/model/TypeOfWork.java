package com.profibay.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.profibay.api.model.enums.TypeOfWorkEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor


@Entity (name = "type_of_work")
public class TypeOfWork extends BaseModel {

    @Column (name = "type_of_work")
    @JsonProperty ("typeOfWork")
    private TypeOfWorkEnum typeOfWork;


}

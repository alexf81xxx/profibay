package com.profibay.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.profibay.api.model.enums.TypeOfWorkEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor


@Entity (name = "type_of_work")
public class TypeOfWork extends BaseModel {

    @Column (name = "type_of_work")
    @JsonProperty ("typeOfWork")
    @Enumerated(EnumType.STRING) // Преобразовать enum в строку при отправке запроса в БД
    private TypeOfWorkEnum typeOfWork;

    @ManyToMany()
    @JoinTable(
            name = "master_to_type_of_work",
            joinColumns = @JoinColumn(name = "type_of_work_id"),
            inverseJoinColumns = @JoinColumn(name = "master_id"))
    @JsonIgnore
    private List<Master> masterLists;

    @Override
    public String toString() {
        return "TypeOfWork{" +
                "id="+getId()+
                " typeOfWork=" + typeOfWork +
                '}';
    }
}

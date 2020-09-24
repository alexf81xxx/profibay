package com.profibay.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.profibay.api.model.enums.StatusesEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass//помечаем, что данный класс является родителем для классов-сущностей
@Data
@NoArgsConstructor
public class BaseModel {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;


    @CreatedDate
    @Column(name = "created")
    private LocalDateTime created;
    @LastModifiedDate
    @Column(name = "updated")
    private LocalDateTime updated;

    @Enumerated(EnumType.STRING) // Переделывает ENUM в строку для БД
    @Column(name = "status")
    private StatusesEnum status;



}

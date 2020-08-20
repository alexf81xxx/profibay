package com.profibay.api.model;

import com.profibay.api.model.enums.Statuses;
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
    private Long id;

    @CreatedDate
    @Column(name = "created")
    private LocalDateTime created;
    @LastModifiedDate
    @Column(name = "updated")
    private LocalDateTime updated;

    @Enumerated(EnumType.STRING) // Переделывает ENUM в строку для БД
    @Column(name = "status")
    private Statuses status;



}

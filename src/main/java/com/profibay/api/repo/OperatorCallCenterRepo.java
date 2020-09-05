package com.profibay.api.repo;

import com.profibay.api.model.OperatorCallCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.beans.IntrospectionException;
import java.util.Date;

public interface OperatorCallCenterRepo extends JpaRepository <OperatorCallCenter, Integer> {

    OperatorCallCenter findByNameAndSurname (String name, String surname);

    @Modifying // Запрос который будет производить вставку не нужны для select
    @Transactional
    @Query(value = "INSERT INTO public.operator_call_center (name, surname, patronyic, birthday, sex, phone1, phone2, city, img, status, note_about_operator, rating, created, updated, patronymic) " +
            "VALUES (:name, :surname, :patronyic, :birthday, :sex, :phone1, :phone2, :city, :img, :status, :note_about_operator,:rating, :created, :updated, :patronymic)",
    nativeQuery = true) // nativeQuery = true - означает что это чистый SQL
    Integer insert(@Param("name") String name, @Param("surname") String  surname,@Param("patronyic") String  patronyic,@Param("birthday") Date birthday,@Param("sex") String  sex,@Param("phone1") String  phone1, @Param("phone2")String  phone2,
                   @Param("city")String  city, @Param("img")String  img,@Param("status") String status,@Param("note_about_operator") String note_about_operator,@Param("rating") Integer rating,
                   @Param("created") Date created,@Param("updated") Date updated,@Param("patronymic") String  patronymic);


}

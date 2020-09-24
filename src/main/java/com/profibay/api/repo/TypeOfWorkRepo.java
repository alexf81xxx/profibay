package com.profibay.api.repo;

import com.profibay.api.model.TypeOfWork;
import com.profibay.api.model.enums.TypeOfWorkEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;


public interface TypeOfWorkRepo extends JpaRepository<TypeOfWork, Integer> {

    List<TypeOfWork> findByTypeOfWorkIn(List<TypeOfWorkEnum> typeOfWork);
}

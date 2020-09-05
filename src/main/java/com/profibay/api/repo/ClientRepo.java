package com.profibay.api.repo;

import com.profibay.api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ClientRepo extends JpaRepository<Client, Integer> {
       Client findByNameAndSurnameAndPhone1 (String name,String surname,String phone1); // Метод должен вернуть клиента


}

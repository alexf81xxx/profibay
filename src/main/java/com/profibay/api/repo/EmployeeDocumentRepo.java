package com.profibay.api.repo;

import com.profibay.api.model.EmployerDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDocumentRepo extends JpaRepository<EmployerDocument, Integer>  {
}

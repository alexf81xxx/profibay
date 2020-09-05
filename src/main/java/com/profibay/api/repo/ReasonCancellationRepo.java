package com.profibay.api.repo;

import com.profibay.api.model.ReasonCancellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReasonCancellationRepo extends JpaRepository<ReasonCancellation, Integer> {
}
